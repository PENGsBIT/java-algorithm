package 回溯.组合总和;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-27 21:04
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode 40 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * @Create: 2019-07-27 21:04
 **/


public class 组合总和II {
    public static List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    private static void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        for (int i = cur; i < cand.length; i++){
            //if checked cand[i-1], while cand[i]==cand[i-1], so can skip i
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), cand[i]);
            if (target - cand[i] >= 0) {
                dfs_com(cand, i+1, target - cand[i], path, res);
            }
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));;
    }
}
