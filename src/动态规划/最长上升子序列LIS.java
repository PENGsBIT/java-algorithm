package 动态规划;

public class 最长上升子序列LIS {
    public static void main(String[] args) {
        System.out.println(LIS(new int[]{1,5,3,4,6,9,7,8}));;
    }
    //o(n2)
    public static int LIS(int[]nums){
        if (nums.length<=1){
            return 0;
        }
        int[]dp=new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 1; j < i; j++) {
                if (nums[j]<nums[i]&& dp[i]<dp[j]){
                    dp[j]=dp[i]+1;
                }
            }
        }
        return dp[nums.length-1];
    }
}
