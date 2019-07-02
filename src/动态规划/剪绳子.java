package 动态规划;

public class 剪绳子 {
    // 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)
    // 每段绳子的长度记为k[0],k[1],...,k[m].请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
    public static int maxMuti(int length) {
        int[] dp = new int[length + 1];
        dp[1] = 1;
        for (int i = 2; i <= length; i++)
            for (int j = 1; j < i; j++)
//                使用dp[i]表示正整数i的最大乘积，则
//        dp[i]=max{dp[i-1]*1,dp[i-2]*2,...,dp[i-(i-1)]*(i-1)
//            (i-1) * 1,(i-2) * 2,(i-3)*3,.....(i) * (i-1)};
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
        return dp[length];
    }
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
    public static void main(String[] args) {
        System.out.println(maxMuti(10));
    }
}
