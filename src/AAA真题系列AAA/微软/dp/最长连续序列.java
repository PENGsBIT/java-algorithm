package AAA真题系列AAA.微软.dp;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 18:46
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zpc
 * @Description: leetcode128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @Create: 2019-09-23 18:46
 **/


public class 最长连续序列 {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> ranges = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (ranges.containsKey(num)) continue;

            // 1.Find left and right num
            int left = ranges.getOrDefault(num - 1, 0);
            int right = ranges.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);

            // 2.Union by only updating boundary
            // Leave middle k-v dirty to avoid cascading update
            if (left > 0) ranges.put(num - left, sum);
            if (right > 0) ranges.put(num + right, sum);
            ranges.put(num, sum); // Keep each number in Map to de-duplicate
        }
        return max;
    }

    public static void main(String[] args) {
        int[]nums={100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
