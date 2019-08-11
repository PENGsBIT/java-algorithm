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
    public int numberOfOne(int n) {
        int count=0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}
