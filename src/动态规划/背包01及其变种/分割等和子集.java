package 动态规划.背包01及其变种;

public class 分割等和子集 {
    public static void main(String[] args) {
        int[] nums={11, 5, 1, 5};
        System.out.println(canPartition(nums));
    }

        public static boolean canPartition(int[] nums) {
            if(nums == null || nums.length == 0)
                return false;
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            if(sum % 2 == 1) return false;
            sum /= 2;
            boolean[] dp = new boolean[sum+1];
            dp[0] = true;
//            第i次迭代的过程只与第i-1次迭代过程有关系
//            而与前i-2次迭代过程无关
//            因此我我们首先可以考虑使用2×sum的滚动数组来解决此题。此时可以把空间复杂度压缩到O(sum)。
//            一维动态规划的思想
//            假设dp[j]表示第i轮迭代能否得到和为j的子数组
//                    那么只要保证此时数组中存储的是
//            上一轮（i-1轮）迭代的结果
//                    我们就可以去掉一个维度
            for(int i = 0; i < nums.length; i++){
                for(int j = sum; j >= nums[i]; j--){
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
            return dp[sum];
        }


    public static boolean canPartition2(int[] nums) {
        int sum=0;
        for (int num:nums) sum+= num;
        if(sum % 2 == 1) return false;
        else{
            int halfsum =sum/2;
            int n=nums.length;
            // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
            int dp[][]=new int[n][halfsum + 1];
            // dp[0][0] 为初始状态，表示，没有任何没有东西没有体积，其余部分初始化
            for(int i=nums[0];i<=halfsum;i++){
                dp[0][i] = nums[0];
            }
            //遍历n个数字，即视为n个产品
            for(int i=1;i<n;i++){
                //加入了这种物品后更新状态
                for(int j=nums[i];j<=halfsum;j++){
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
                }
            }
            //放满了才能表示正好1/2
            if(dp[n-1][halfsum]==halfsum)
                return true;
            else
                return false;
        }

    }


}
