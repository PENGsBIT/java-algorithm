package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-26 23:10
 **/

/**
 * @Author: zpc
 * @Description: leetcode 213抢劫问题
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。

 * @Create: 2019-07-26 23:10
 **/


public class 环中找相隔选取最大值 {
    public static int chooseMaxInCircle(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        //分成两个子问题：
        // 子问题1：在0 ~ i-2这个范围里选取(选了0就不能选与0相邻的i-1)
        // 问题2：在1 ~ i-1(选了1就不能选与1相邻的0)
        return Math.max(chooseCore(nums, 0, nums.length - 2), chooseCore(nums, 1, nums.length - 1));
    }

    private static int chooseCore(int[] nums, int strart, int end) {
        int n=end-strart+1;
        //dp记录从start开始在这n个数里目前能得到的max
        int[]dp=new int[n];
        dp[0] = nums[strart];
       dp[1] = Math.max(nums[strart], nums[strart+1]);
        for (int i = 2; i <n ; i++) {
            //选不选start+i位的数
            dp[i] = Math.max(dp[i - 2] + nums[strart + i], dp[i - 1]);
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {

        System.out.println(chooseMaxInCircle(new int[]{1,3,1,3,100}));
    }
}
