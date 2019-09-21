package 闭包;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 23:14
 **/

/**
 * @Author: zpc
 * @Description:
 * 闭包最早定义为一种包含<环境成分>和<控制成分>的实体.
 *
 * 解释一：闭包是引用了自由变量的函数，这个被引用的变量将和这个函数一同存在。
        *      那么什么是自由变量呢?自由变量就是在函数自身作用域之外的变量,一个函数f(x)=x+y,其中y就是自由变量,
        *     // 它并不是这个函数自身的自变量,而是通过外部环境提供的.
        *     //
        *     //下面以JavaScript的一个闭包为例:
        *     //
        *     //function Add(y) {
        *     //	return function(x) {
        *     //		return x + y;
        *     //	}
        *     //}
        *     //对于内部函数function(x)来说,y就是自由变量.而y是函数Add(y)内的参数,
        *      所以Add(y)对内部函数function(x)形成了一个闭包.
        *     //
        *     //这个闭包将自由变量y与内部函数绑定在了一起,也就是说,当Add(y)函数执行完毕后,它不会随着函数调用结束后被回收(不能在栈上分配空间).
        *     //
        *     //var add_function = Add(5); // 这时y=5,并且与返回的内部函数绑定在了一起
        *     //var result = add_function(10); // x=10,返回最终的结果 10 + 5 = 15
 * 解释二：闭包是函数和相关引用环境组成的实体。
 *
 * 注：<自由变量>：除了局部变量的其他变量
 *
 *  
 *
 * 简单理解：闭包能够将一个方法作为一个变量去存储，这个方法有能力去访问所在类的自由变量。
 * @Create: 2019-09-20 23:14
 **/


public class 闭包实例 {

    //Java与JavaScript又或者其他支持闭包的语言不同,它是一个基于类的面向对象语言,
    // 也就是说一个方法所用到的自由变量永远都来自于其所在类的实例的.
    //java中能够保存方法的变量指的就是普通的对象
    //如何让这个普通对象能够访问所在类的自由变量？
    //纯天然的解决办法是：内部类。内部类能够访问外部类的所有属性及方法。
    //隐藏具体实现是内部类的作用之一，如何保证隐藏具体实现的同时还能将闭包传递到外部使用？
    //
    //让内部类实现通用接口，然后将内部类对象向上转型为接口类型。
    //
    //上述解决办法就是Java最常用的闭包实现办法（内部类+接口）
    private int y = 5;
    private class Inner {
        private int x = 10;
        public int add() {
            return x + y;
        }
    }
    //getAnonInner(x)方法返回了一个匿名内部类AnonInner,匿名内部类不能显式地声明构造函数,
    // 也不能对构造函数传参,且返回的是一个AnonInner接口,
    // 但它的add()方法实现中用到了两个自由变量(x与y),也就是说外部方法getAnonInner(x)对这个匿名内部类构成了闭包.
    //但我们发现自由变量都被加上了final修饰符,这是因为Java对闭包支持的不完整导致的.
    public AnonInner getAnonInner(final int x) {
        final int y = 5;
//        return new AnonInner() {
//            public int add() {
//                return x + y;
//            }
//        };
        return () -> x + y;
    }

}


