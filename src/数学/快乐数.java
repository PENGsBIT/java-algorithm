package 数学;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 16:59
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zpc
 * @Description: leetcode202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @Create: 2019-09-24 16:59
 **/


public class 快乐数 {
    //The idea is to use one hash set to record sum of every digit square of every number occurred.
    // Once the current sum cannot be added to set, return false;
    // once the current sum equals 1, return true;
    public static boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
