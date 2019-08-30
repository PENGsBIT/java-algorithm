package 数组;

//456. 132模式
//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
//注意：n 的值小于15000。
//
//示例1:
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//示例 2:
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//示例 3:
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].

import java.util.Arrays;

public class 模式132 {
    //Naive O(n^3) solution
    public static boolean find132patternO3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;
    }
    //Optimized 2 O(n) solution
    public static boolean find132patternOp(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }

        return false;
    }
    //One-pass O(n) solution
    public static boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            nums[--top] = nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(find132patternO3(nums));
        System.out.println(find132patternOp(nums));
        System.out.println(find132pattern(nums));
    }
}
