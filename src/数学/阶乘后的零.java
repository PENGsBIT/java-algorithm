package 数学;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-17 15:29
 **/

/**
 * @Author: zpc
 * @Description: leetcode172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @Create: 2019-09-17 15:29
 **/


public class 阶乘后的零 {
    //先找5的倍数，再找5*5的倍数，再找5*5*5的倍数，再将这些值都加起来就是0的个数
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }
}
