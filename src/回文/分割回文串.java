package 回文;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-27 23:07
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode 131 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * @Create: 2019-07-27 23:07
 **/


public class 分割回文串 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    //回溯法 O(n*(2^n))
    public List<List<String>> partition(String s) {
        dfs(s, 0, temp, res);
        return res;
    }

    private void dfs(String s, int cur, List<String> temp, List<List<String>> res) {
        if (cur == s.length()) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = cur; i < s.length(); i++) {
                if (isPal(s, cur, i)) {
                    temp.add(s.substring(cur, i + 1));
                    dfs(s, i + 1, temp, res);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private boolean isPal(String s, int low, int high) {
        while (low < high) if (s.charAt(low++) != s.charAt(high--)) {
            return false;
        }
        return true;
    }

    //DP
    public static List<List<String>> DPpartition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
