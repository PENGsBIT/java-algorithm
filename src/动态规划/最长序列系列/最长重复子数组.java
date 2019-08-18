package 动态规划.最长序列系列;

public class 最长重复子数组 {
    //以数组A为X轴，数组B为Y轴建立一个大小为A.length*B.length大小的二维矩阵。
    //
    //对于矩阵中的每一个位置(i, j)，如果A[j] == B[i]，则该位置的值等于其左上方位置（i-1,j-1）的值加1。
    //该矩阵中的最大值即为最长公共子数组长度。
    //算法的时间复杂度为O(n^2)
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int res = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
