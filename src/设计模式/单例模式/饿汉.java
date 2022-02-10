package 设计模式.单例模式;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-19 22:49
 **/

import java.lang.reflect.Constructor;

/**
 * @Author: zpc
 * @Description: 单例
 * @Create: 2019-07-19 22:49
 **/


public class 饿汉 {
    public static void main(String[] args) throws Exception {
         eHanSingleton s = eHanSingleton.getInstance();

        // 拿到所有的构造函数，包括非public的
        Constructor<eHanSingleton> constructor = eHanSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        // 使用空构造函数new一个实例。即使它是private的~~~
        eHanSingleton sReflection = constructor.newInstance();

        System.out.println(s); //com.fsx.bean.Singleton@1f32e575
        System.out.println(sReflection); //com.fsx.bean.Singleton@279f2327
        System.out.println(s == sReflection); // false
        //单例创建出了一个新的实例对象。所以这种方式也还是存在不安全因素的。
    }
}
class eHanSingleton {
     //当类第一次被加载到内存它就实例化了，所以这种实例的创建方式是线程安全的。
    private static final eHanSingleton instance = new eHanSingleton();

    private eHanSingleton() {}

    public static eHanSingleton getInstance() {
        return instance;
    }

}
