package 设计模式.单例模式;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-19 22:50
 **/

/**
 * @Author: zpc
 * @Description: 单例
 * @Create: 2019-07-19 22:50
 **/


public class 懒汉 {
}
class lanHanSinleton {
    private static lanHanSinleton sinleton;
    lanHanSinleton(){
    }

    public static synchronized lanHanSinleton getInstance() {
        if (sinleton == null) {
            return new lanHanSinleton();
        }
        return sinleton;
    }
}
