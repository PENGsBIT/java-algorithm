package java创建对象;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 21:24
 **/

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-24 21:24
 **/


public class java创建对象的四种方式 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        //1、new
            User user = new User("wangql",18);
        //2、运用反射手段，调用Java.lang.Class或者java.lang.reflect.Constructor类的newInstance()实例方法。
            //创建方法1
            User user1 = (User)Class.forName("根路径.User").newInstance();
            //创建方法2（用这个最好）
            User user2 = User.class.newInstance();
            // java.lang.reflect.Constructor类里也有一个newInstance方法可以创建对象。
            //  我们可以通过这个newInstance方法调用有参数的和私有的构造函数。
            Constructor<User> constructor = User.class.getConstructor();
            User user3 = constructor.newInstance();
         //3、使用clone方法
            User cloneTest = new User("wangql",18);
        //4、反序列化一个对象的时候，JVM会给我们创建一个对象。但是，
        // 反序列化的时候JVM并不会去调用类的构造函数(前边两种方式都会去调用构造函数)来创建对象，
        // 而是通过之前序列化对象的字节序列来创建的。
        User u6=new User("xiaohei",3);
        FileOutputStream fos = new FileOutputStream("dog.txt");
        ObjectOutputStream ops = new ObjectOutputStream(fos);
        ops.writeObject(u6);
        System.out.println("dog对象序列化完成");
        //现在我们再次将刚才序列化后的对象反序列化回来，这次用到的是ObjectInputStream的readObject方法：
        FileInputStream fis=new FileInputStream("dog.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        User dog=(User) ois.readObject();
        System.out.println("我叫"+dog.name+"今年"+dog.age+"岁了");
        System.out.println("对象反序列化完成");
    }

}
class User implements Cloneable , Serializable {
    public String name;
    public int age;

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        try {
            User u = new User("wangql",18);
            User copyClone = (User) u.clone();
            System.out.println("newclone:"+u.name);
            System.out.println("copyClone:"+copyClone.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}

