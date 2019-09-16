package AAA真题系列AAA.微软.dp;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-16 22:33
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: leetcode 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @Create: 2019-09-16 22:33
 **/


public class 最长上升子序列 {
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
            //i<0表示要插入的位置
            if(i < 0){
                i = -(i + 1);
                dp[i] = x;
            }
            if(i == len) len++;
        }

        return len;
    }
    //o(n2)
    public static int LIS(int[]nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i <nums.length ; i++) {
            dp[i] = 1;
            for (int j = 0; j <i ; j++) {
                if (nums[j] < nums[i]) {
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(LIS(new int[]{2,1,5,3,6,4,8,9,7}));
        System.out.println(lengthOfLIS(new int[]{2,1,5,3,6,4,8,9,7}));
        System.out.println(lengthOfLIS1(new int[]{2,1,5,3,6,4,8,9,7}));
    }
}
