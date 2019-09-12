package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-12 21:30
 **/

/**
 * @Author: zpc
 * @Description: leetcode221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * @Create: 2019-09-12 21:30
 **/


public class 最大正方形 {
    //dp[i][j] 代表在以i, j这一格为右下角的正方形边长。
    //如果这一格的值也是1，那这个正方形的边长就是他的上面，左手边，和斜上的值的最小边长 +1。
    // 因为如果有一边短了缺了，都构成不了正方形。
    public int maximalSquare(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    //那这个正方形的边长就是他的上面，左手边，和斜上的值的最小边长 +1。
                    dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;
                    result = Math.max(dp[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
