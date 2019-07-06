package 动态规划;

public class 最长上升子序列LIS {
    public static void main(String[] args) {
        System.out.println(LIS(new int[]{1,5,3,4,6,9,7,8}));
    }
    //o(n2)
    public static int LIS(int[]nums){
        if (nums.length<=1){
            return 0;
        }
        int[]dp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;//初始化
            for(int j=0;j<i;j++){//枚举i之前的每一个j,每一个 i ，枚举在 i 之前的每一个元素 j ，
                // 然后对于每一个 dp[j]dp[j] ,如果元素 i 大于元素 j ，
                // 那么就可以考虑继承，而最优解的得出则是依靠对于每一个继承而来的 dp 值，取 max .
                if(nums[j]<nums[i] && dp[i]<dp[j]+1)
                    //用if判断是否可以拼凑成上升子序列，
                    //并且判断当前状态是否优于之前枚举
                    //过的所有状态,如果是，则↓
                    dp[i]=dp[j]+1;//更新最优状态
                 }

        }
        return dp[nums.length-1];
    }
    //O(nlogn)
    public static int optimizeLIS(int[]nums){
        int score = 0;
        int n=nums.length;
        int[]dp=new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            score = Math.max(score, dp[i]);
        }
       return score;
    }
}
