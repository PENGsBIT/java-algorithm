package AAA真题系列AAA.微软;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 18:11
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zpc
 * @Description: leetcode127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @Create: 2019-09-23 18:11
 **/


public class 单词接龙 {
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int edit = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            edit++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return edit;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(ladderLength(beginWord,endWord,wordList));

    }
}
