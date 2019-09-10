/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-08 15:41
 **/

/**
 * @Author: zpc
 * @Description: leetcode903. DI 序列的有效排列
 * 我们给出 S，一个源于 {'D', 'I'} 的长度为 n 的字符串 。（这些字母代表 “减少” 和 “增加”。）
 * 有效排列 是对整数 {0, 1, ..., n} 的一个排列 P[0], P[1], ..., P[n]，使得对所有的 i：
 *
 * 如果 S[i] == 'D'，那么 P[i] > P[i+1]，以及；
 * 如果 S[i] == 'I'，那么 P[i] < P[i+1]。
 * 有多少个有效排列？因为答案可能很大，所以请返回你的答案模 10^9 + 7.
 *
 * @Create: 2019-09-08 15:41
 **/


public class 爱奇艺1 {
    //DP(O^2)
    //dp[i][j]表示前i + 1位可能排列的个数，
    //其中i + 1位是j + 1在其余的数中最小的。
    //我以S = "DID"为例。
    //排列可以从1 2 3 4开始。
    //所以dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 1。
    //在括号中，我列出了所有可能的排列。
    //我们从第一个数到第二个数，
    //向下箭头表示所有可能的递减路径。
    //同样的，因为我们从第二位数增加到第三位数，
    //向上箭头表示所有可能增加的路径。
    //dp[2][1] = 5，表示排列数
    //第三个数字是第二小的。
    //我们有413,314,214,423,324。
    //例413中，还剩下2 3，还有3是第二小的。
    //解释:
    //如图所示，
    //对于I，我们计算数组的前缀和，
    //对于“D”，我们计算数组的sufixsum。
    public int numPermsDISequence(String S) {
        int n = S.length(), mod = (int)1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++)
            if (S.charAt(i) == 'I')
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % mod;
        return dp[n][0];
    }
}
