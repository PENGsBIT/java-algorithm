package 动态规划.子序列系列;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 20:47
 **/

/**
 * @Author: zpc
 * @Description: leetcode53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @Create: 2019-09-24 20:47
 **/


public class 最大子序和 {
    public static int dpmaxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) { sum = nums[i]; }
            else {sum += nums[i]; }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(a));
    }
}
