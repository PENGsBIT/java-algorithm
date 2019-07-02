package 数学;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-02 23:03
 **/

public class randa2randb {
    //Rand5() + Rand5() - 1
//    上述代码可以生成1到9的数，但它们是等概率生成的吗？不是。生成1只有一种组合：
// 两个Rand5()都生成1时：(1, 1)；而生成2有两种：(1, 2)和(2, 1)；生成6更多。
// 它们的生成是不等概率的。那要怎样找到一个等概率生成数的组合呢？
    //5 * (Rand5() - 1) + Rand5()
    //
    //Rand5产生1到5的数，减1就产生0到4的数，乘以5后可以产生的数是：0,5,10,15,20。
    // 再加上第二个Rand5()产生的1,2,3,4,5。我们可以得到1到25， 而且每个数都只由一种组合得到，
    // 即上述代码可以等概率地生成1到25。
    public static int Rand5(){
        return (int) Math.ceil(Math.random()*5);
    }
    public static int Rand7(){
        int x = ~(1<<31); // max int
        while(x > 21)
            x = 5 * (Rand5() - 1) + Rand5(); // Rand25
        return x%7 + 1;
    }
//从上面一系列的分析可以发现，如果给你两个生成随机数的函数Randa和Randb， 你可以通过以下方式轻松构造Randab，生成1到a*b的随机数。
//Randab = b * (Randa - 1) + Randb
//Randab = a * (Randb - 1) + Randa
    public static void main(String[] args) {
        System.out.println();
    }
}
