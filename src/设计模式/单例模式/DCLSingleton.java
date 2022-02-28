package 设计模式.单例模式;

//double checked locking模式
public class DCLSingleton {
    //可能会出现空指针问题，出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。当某个线程获取锁进行实例化时，其他线程就直接获取实例使用，
    // 由于JVM指令重排序的原因，其他线程获取的对象也许不是一个完整的对象，所以在使用实例的时候就会出现空指针异常问题。
    private volatile static DCLSingleton DCLSingleton;//将 instance 变量声明成 volatile 保证JVM 的即时编译器中不会指令重排序的优化

    private DCLSingleton() {};

    public static DCLSingleton getDCLSingleton() {
        if (DCLSingleton == null) {
            synchronized (DCLSingleton.class) {
//                同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，
// 如果在同步块内不进行二次检验的话就会生成多个实例了。
                if (DCLSingleton == null) {
//                    instance = new 设计模式.单例模式.DCLSingleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情:
//                    1.给 instance 分配内存
//                    2.调用 设计模式.单例模式.DCLSingleton 的构造函数来初始化成员变量
//                    3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）。

                    DCLSingleton = new DCLSingleton();
                }
            }
        }
        return DCLSingleton;
    }
}
//对双重检查锁定的升级版本
class DCLOptimizeSingleton {
    //volatile关键字严格遵循happens-before原则，即在读操作前，写操作必须全部完成。
    private static volatile DCLOptimizeSingleton instance = null;

    private DCLOptimizeSingleton() {}

    public static DCLOptimizeSingleton getInstance () {
        DCLOptimizeSingleton inst = instance;  // <<< 在这里创建临时变量
        if (inst == null) {
            synchronized (DCLOptimizeSingleton.class) {
                inst = instance;
                if (inst == null) {
                    inst = new DCLOptimizeSingleton();
                    instance = inst;
                }
            }
        }
        return inst;  // <<< 注意这里返回的是临时变量
    }
}
