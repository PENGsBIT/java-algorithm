package 动态规划.子序列系列;

import java.util.Arrays;

public class 最长上升子序列LIS {
    public static void main(String[] args) {
        //2 1 5 3 6 4 8 9 7，可以看出来它的LIS长度为5
        System.out.println(lengthOfLIS(new int[]{2,1,5,3,6,4,8,9,7}));
        System.out.println(LIS1(new int[]{2,1,5,3,6,4,8,9,7}));
        System.out.println(LIS(new int[]{2,1,5,3,6,4,8,9,7}));
    }
    //o(n2)
    public static int LIS(int[]nums){
        if(nums == null || nums.length==0)
            return 0;
        int[]dp=new int[nums.length];
        int maxlen=1;
        //Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;//初始化
            for(int j=0;j<i;j++){//枚举i之前的每一个j,每一个 i ，枚举在 i 之前的每一个元素 j ，
                // 然后对于每一个 dp[j],如果元素 i 大于元素 j ，
                // 那么就可以考虑继承，而最优解的得出则是依靠对于每一个继承而来的 dp 值，取 max .
                if(nums[j]<nums[i])
                    //用if判断是否可以拼凑成上升子序列，
                    //并且判断当前状态是否优于之前枚举
                    //过的所有状态,如果是，则↓
                    dp[i]=Math.max(dp[j]+1,dp[i]);//更新最优状态
                 }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
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
    //贪心+二分查找数位置
    public static int lengthOfLIS(int[] nums) {
        //tails是一个在tails[k]存储长度为k+1的所有递增子序列的长的上升子序列的最末元素，若有多个长度为k+1的上升子序列，则记录最小的那个最末元素
        // 。例如，我们有一个nums = [4, 5, 6, 3]，那么所有的递增子序列是：
        //
        //# 长度为1
        //[4], [5], [6], [3]          =>  tails[0] = 3
        //# 长度为2
        //[4, 5], [5, 6], [4, 6]      =>  tails[1] = 5
        //# 长度为3
        //[4, 5, 6]                   =>  tails[2] = 6
        // ————————————————
        int[] tails = new int[nums.length];
        int curMaxSize = 0;
        //tails[0]一定是所有元素中最小的那个数字min1，因为长度为1的子序列中，
        // 结尾最小的数字就是序列中最小的那个。同样，长度为2的子序列中，结尾最小的的那个子序列的结尾元素一定大于min1，
        // 因为首先所有长度为2的递增子序列，第二个元素一定比第一个元素大，如果长度为2的子序列中某个子序列的结尾元素小于min1，
        // 那么在第一次操作中，这个元素就会更新为min1。
        for (int num : nums) {
            int i = 0, j = curMaxSize;
            //二分查找， 找到在tails数组中需要被更新的那个数。
            while (i != j) {
                int m = i+(j-i) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = num;
            if (i == curMaxSize){
                ++curMaxSize;
            }
        }
        return curMaxSize;
    }
    public static int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
