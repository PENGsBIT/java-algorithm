package 数组;

import java.util.ArrayList;
import java.util.List;

import static K.第K个.swap;

public class 数组中重复的数字 {
    //在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    //要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
    //对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
    public ArrayList<Integer> duplicate(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    res.add(nums[i]);
                }
                swap(nums, i, nums[i]);
            }
        }
       return res;
    }
}
