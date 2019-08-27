package DFS;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-27 22:03
 **/

import java.util.*;

/**
 * @Author: zpc
 * @Description: leetcode 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * @Create: 2019-08-27 22:03
 **/


public class 单词拆分II {
    //直接使用DFS会导致TLE，所以使用HashMap来保存之前的结果
    // 来修剪重复的分支，如下所示:
    static Set<String> wordDict;
    public static List<String> wordBreak(String s, Set<String> Dict) {
        wordDict=Dict;
        return DFS(s,new HashMap<>());
    }

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, Map<String, List<String>>map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("pineapplepenapple", new HashSet<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
    }
}
