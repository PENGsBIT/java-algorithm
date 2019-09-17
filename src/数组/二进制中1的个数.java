package 数组;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-11 14:42
 **/

/**
 * @Author: zpc
 * @Description: 剑指offer
 * @Create: 2019-08-11 14:42
 **/


public class 二进制中1的个数 {
    public static int numberOfOne(int n) {
        int count=0;
        //为什么n &= (n – 1)能清除最右边的1呢？因为从二进制的角度讲，n相当于在n - 1的最低位加上1。举个例子，8（1000）= 7（0111）+ 1（0001），所以8 & 7 = （1000）&（0111）= 0（0000），清除了8最右边的1（其实就是最高位的1，因为8的二进制中只有一个1）。
        // 再比如7（0111）= 6（0110）+ 1（0001），
        // 所以7 & 6 = （0111）&（0110）= 6（0110），清除了7的二进制表示中最右边的1（也就是最低位的1）。
        while (n != 0) {
            count++;
            //o(m)m为1的个数
           n &= (n - 1);
           //o(log2n)
            //n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(3));
    }
}
