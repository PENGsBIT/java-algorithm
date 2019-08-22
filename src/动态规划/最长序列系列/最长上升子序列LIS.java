package 动态规划.最长序列系列;

public class 最长上升子序列LIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,5,3,4,6,9,7,8}));
        System.out.println(LIS1(new int[]{1,5,3,4,6,9,7,8}));
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
                // 然后对于每一个 dp[j],如果元素 i 大于元素 j ，
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
    //O(n2)
    public static int LIS1(int[]nums){
        int score = 0;
        int count = 0;
        int n=nums.length;
        int[]dp=new int[n];
        //
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            if (score < dp[i]) {
                score = dp[i];
                count++;
            }
        }
       return count;
    }
    //O(nlogn)
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = num;
            if (i == size){
                ++size;
            }

        }
        return size;
    }
}
