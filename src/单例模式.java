public class 单例模式 {

}
//这种写法仍然使用JVM本身机制保证了线程安全问题。由于静态单例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton，**第一次调用getInstance()时将加载内部类SingletonHolder **，在该内部类中定义了一个static类型的变量INSTANCE ，此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。由于getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响。
//由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本。

class Singleton {
    private volatile static Singleton singleton;//将 instance 变量声明成 volatile 保证JVM 的即时编译器中不会指令重排序的优化

    private Singleton() {};

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
//                同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，
// 如果在同步块内不进行二次检验的话就会生成多个实例了。
                if (singleton == null) {
//                    instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情:
//                    1.给 instance 分配内存
//                    2.调用 Singleton 的构造函数来初始化成员变量
//                    3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）。

                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
//    静态内部类 static nested class
//    这种方法也是《Effective Java》上所推荐的。
class Singleton1 {
    private static class SingletonHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    private Singleton1() {
    }

    public static final Singleton1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
