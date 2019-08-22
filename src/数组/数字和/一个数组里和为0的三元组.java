package 数组.数字和;

//leetcode 15
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//

import java.util.*;

public class 一个数组里和为0的三元组 {
    public static Set<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < num.length-2; i++) {
            //避免重复选择
            //if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            //滑动窗口
                int low = i+1, hi = num.length-1, cur = num[i];
                while (low < hi) {
                    if (num[low] + num[hi]+cur == 0) {
                        res.add(Arrays.asList(num[i], num[low], num[hi]));
                        //while (low < hi && num[low] == num[low+1]) low++;
                        //while (low < hi && num[hi] == num[hi-1]) hi--;
                        low++; hi--;
                    } else if (num[low] + num[hi] + cur > 0) {
                        low++;
                    } else {
                        hi--;
                    }
                }
            //}
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
