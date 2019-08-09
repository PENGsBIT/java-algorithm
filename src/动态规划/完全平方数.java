package 动态规划;

//279. 完全平方数
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//示例 1:
//
//输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//示例 2:
//
//输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
//

import java.util.Arrays;

public class 完全平方数 {
    //dp[0] = 0
    //dp[1] = dp[0]+1 = 1
    //dp[2] = dp[1]+1 = 2
    //dp[3] = dp[2]+1 = 3
    //dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
    //      = Min{ dp[3]+1, dp[0]+1 }
    //      = 1
    //dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
    //      = Min{ dp[4]+1, dp[1]+1 }
    //      = 2
    //						.
    //						.
    //						.
    //dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
    //       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
    //       = 2
    //						.
    //						.
    //						.
    //dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1


    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }



    //用 dp[i] 数组存储第 i 个数的完美平方数。递推式为：dp[i] = Math.max(dp[j] + dp[i-j], dp[i]，
    // 认为 i 的完全平方数是从和为 i 的两个完全平方数 dp[j] 和 dp[i-j]之和，然后从中取最小。
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int sqr = (int) Math.sqrt(i);
            if (sqr * sqr == i)
                dp[i] = 1;  //如果 i 本身是个平方数，就将 dp[i] 置1
            else {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);  //从0开始遍历所有和为 i 的 dp，使得 dp[i]取最小
                }
            }
        }
        return dp[n];
    }

}
