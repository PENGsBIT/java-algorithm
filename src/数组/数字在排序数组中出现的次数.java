package 数组;

import java.util.Arrays;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 11:36
 **/

public class 数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] nums, int K) {
        int first = Arrays.binarySearch(nums, K);
        int last = Arrays.binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }
}
