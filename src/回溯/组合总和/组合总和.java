package 回溯.组合总和;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-27 22:29
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode 39 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * @Create: 2019-07-27 22:29
 **/


public class 组合总和 {
    //回溯法
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int cur) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = cur; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //动态规划法
    public List<List<Integer>> DPCombinationSum(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> tempList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) tempList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i - cands[j] - 1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]);
                        cl.addAll(l);
                        tempList.add(cl);
                    }
                }
            }
            dp.add(tempList);
        }
        return dp.get(t - 1);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }
}
