package AAA真题系列AAA.腾讯;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 21:54
 **/

import java.util.Scanner;

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-20 21:54
 **/


public class 腾讯3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n + 1];
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                nums[i] = scanner.nextInt();
                sum += nums[i];
            }
            findScore(n, sum, nums);
        }
    }

    public static void findScore(int n, int sum, int[] nums) {
        boolean[][] dp = new boolean[n / 2 + 1][sum + 1];
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for (int k = 1; k <= n; k++) {
            for (int i = Math.min(n / 2, k); i >= 1; i--) {
                for (int j = nums[k]; j < sum; j++) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[k]];
                }
            }
        }
        int ans = sum;
        for (int j = 0; j < sum; j++) {
            if (dp[n / 2][j]) {
                ans = Math.min(ans, Math.abs(sum - j - j));
            }
        }
        System.out.println((sum - ans) / 2 + " " + (sum + ans) / 2);
    }
}
