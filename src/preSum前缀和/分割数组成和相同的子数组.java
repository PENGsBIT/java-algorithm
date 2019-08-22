package preSum前缀和;

//leetcode 548
//Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:
//
//0 < i, i + 1 < j, j + 1 < k < n - 1
//Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
//where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
//Example:
//Input: [1,2,1,2,1,2,1]
//Output: True
//Explanation:
//i = 1, j = 3, k = 5.
//sum(0, i - 1) = sum(0, 0) = 1
//sum(i + 1, j - 1) = sum(2, 2) = 1
//sum(j + 1, k - 1) = sum(4, 4) = 1
//sum(k + 1, n - 1) = sum(6, 6) = 1
//Note:
//
//1 <= n <= 2000.
//Elements in the given array will be in range [-1,000,000, 1,000,000].

import java.util.HashSet;

public class 分割数组成和相同的子数组 {
    public static boolean splitSubArraySumEqual(int[] nums) {
        if (nums.length < 7) {
            return false;
        }
        int[] sum = new int[nums.length];
//        sum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i];
//        }
        for (int i = 0,j=0; i <nums.length; i++) {
            j += nums[i];
            sum[i]=j;
        }
        //从j的位置开始找,确定j的范围应该左右各留3个数字，因为四段均不能为空，而且分割位上的数字不能算入四段
        for (int j = 3; j < nums.length - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i])
                    set.add(sum[i - 1]);
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j]))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]nums={1,2,1,2,1,2,1};
        System.out.println(splitSubArraySumEqual(nums));
    }

}
