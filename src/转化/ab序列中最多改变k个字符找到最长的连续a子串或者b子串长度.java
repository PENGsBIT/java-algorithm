package 转化;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-11 17:05
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zpc
 * @Description: 【尺取法】ab序列中最多改变k个字符找到最长的连续a子串或者b子串长度
 * @Create: 2019-08-11 17:05
 **/


public class ab序列中最多改变k个字符找到最长的连续a子串或者b子串长度 {
    public static int deal(char[] s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s) {
            charMap.put(c,charMap.getOrDefault(c,1)+1);
        }
        int max=0;
        char major=' ';
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > max) {
                max=entry.getValue();
                major=entry.getKey();
            }
        }
        charMap.remove(major);
        //【尺取法】ab序列中最多改变k个字符找到最长的连续a子串或者b子串长度
        int r = 0, l = 0, res = 0, cnt = 0;
        for (int i = 0; i < s.length; i++) {
            //if (s[i] != 'a') {
            if (s[i] != major) {
                if (cnt < k) {
                    r++;
                    cnt++;
                } else {
                    //while (l < s.length && s[l] != 'b') l++;
                    while (l < s.length && !charMap.containsKey(s[l])) l++;
                    l++;
                    r++;
                }
            } else r++;
            res = Math.max(res, r - l);
        }
        return res;


    }


    public static void main(String[] args) {
        //System.out.println(longestSubStr("abba",2));
        System.out.println(deal("aabaabaa".toCharArray(), 1));
        System.out.println(deal("NSNNNNGNNNNNNNNSNNNN".toCharArray(), 2));
    }


}
