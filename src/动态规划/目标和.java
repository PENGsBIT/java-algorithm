package 动态规划;

public class 目标和 {
    //    该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
//
//    可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
//
//    sum(P) - sum(N) = target
//    sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                       2 * sum(P) = target + sum(nums)
//    因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        int target = 5;
        System.out.println(zeroandonebag(a, target));
    }

    public static int zeroandonebag(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(sum<target||(sum+target)%2==1){
            return 0;
        }
        int half=(sum+target)>>1;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = half; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
         return dp[half];
    }
}
