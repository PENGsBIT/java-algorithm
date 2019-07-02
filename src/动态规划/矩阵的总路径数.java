package 动态规划;

import java.util.Arrays;

public class 矩阵的总路径数 {
    public static void main(String[] args) {
        System.out.println(uniquePaths1(7,3));
    }
    private int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static int uniquePaths1(int m, int n) {
        int S = m + n - 2;  // 总共的移动次数
        int D = n - 1;      // 向下的移动次数
        long ret1 = 1,ret2=1;
        for (int i = 1; i <= D; i++) {
         ret1 *= (S-i+1);
         ret2*=i;
        }
        return (int) (ret1/ret2);
    }
}
