package 数组;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 16:40
 **/

/**
 * @Author: zpc
 * @Description: leetcode829. 连续整数求和
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 *
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 *
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明: 1 <= N <= 10 ^ 9
 *
 * @Create: 2019-09-24 16:40
 **/


public class 连续整数求和 {
    //把N表示成一个等差数列（公差为1）的和
    //我们不妨设这个数列的首项是x，项数为m，则这个数列的和就是[x + (x + (m-1))]m / 2 = mx + m(m-1)/2 = N
    //接下来，一个很自然的想法就是，枚举m，通过上式判断对于相应的m是否存在合法的x。
    //x = ((N - m(m-1)/2)) / m
    //显然枚举的复杂度是O(sqrt(N))。因为m能取到的最大值显然是sqrt(n)数量级的
    static int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int m = 1; ; m++) {
            int mx = N - m * (m-1) / 2;
            if (mx <= 0)
                break;
            //例如：mx==14 and m==3则可以看出没有合法的x符合
            if (mx % m == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(15));
    }
}
