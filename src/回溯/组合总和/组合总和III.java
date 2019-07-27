package 回溯.组合总和;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-27 23:01
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode 216 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * @Create: 2019-07-27 23:01
 **/


public class 组合总和III {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private static void combination(List<List<Integer>> ans, List<Integer> temp, int k,  int start, int target) {
        if (temp.size() == k && target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target||temp.size()>k) {
                break;
            }
            temp.add(i);
            combination(ans, temp, k, i+1, target-i);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(combinationSum3(3,7));
        System.out.println(combinationSum3(3,9));
    }
}
