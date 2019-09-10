package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-10 10:05
 **/

import java.util.Stack;

/**
 * @Author: zpc
 * @Description: leetcode316. 去除重复字母
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 * @Create: 2019-09-10 10:05
 **/


public class YY2去除重复字母 {
    //给定字符串s，贪婪的选择（即答案中最左边的字母）是最小的s [i]，st
    //后缀s [i ..]包含所有唯一字母。（注意，当有多个最小的s [i]时，我们选择最左边的一个。为什么？只需考虑一下这个例子：“abcacb”。）
    //
    //在确定贪心选择s [i]之后，我们从s by获得一个新的字符串s'
    //删除s [i]左边的所有字母，
    //从s中删除所有s [i]。
    //运行时为O（26 * n）= O（n）。
    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
    //1. 扫描字符串，结果串置空；
    //2. 如果当前字符用过了，扫描下一个；
    //3. 如果当前字符串没用过，则判定结果串的字符串是否存在需要优化的字符。
    // 优化的条件：里面有大于当前字符的，并且后面存在重复的，也就是用后面的即可。
    //4. 重复2,3步骤直到无字符串可以扫描。
    //5. 按先进先出的原则输出结果串。
    public static String stackRemoveDuplicateLetters(String s) {
        //统计每个字符出现的次数
        int [] count = new int[26];
        char cs [] = s.toCharArray();
        for(char c: cs)
        {
            count[c-'a']++;
        }

        //每个字符是否使用，由于只保留一个，所以这地方最多需要26个。
        boolean visited [] = new boolean[26];

        //结果集
        Stack<Character> result = new Stack<>();
        for(char c: cs)
        {
            count[c-'a']--;
            //结果集里已经有了，不需要再放进来了。
            if(visited[c-'a'])
                continue;

            //优化步骤
            while(!result.isEmpty() && count[result.peek()-'a']>0 && c<result.peek())
            {
                //后面有更好的，则删除，设置为没有用过。
                visited[result.peek()-'a']=false;
                result.pop();
            }

            //更新状态
            result.push(c);
            visited[c-'a'] = true;
        }
        s = "";
        //正序，先入的先出！
        for(char c: result)
            s+=c;

        return s;
    }

    public static void main(String[] args) {
        System.out.println(stackRemoveDuplicateLetters("acbcabc"));
    }
}
