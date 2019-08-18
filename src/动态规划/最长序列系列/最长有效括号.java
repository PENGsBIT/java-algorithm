package 动态规划.最长序列系列;

//leetcode 32
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//示例 1:
//
//输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//示例 2:
//
//输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//

import java.util.Stack;

public class 最长有效括号 {
    //1.从头到尾扫描字符串。
    //
    //2.如果当前字符为'（'，
    //将其索引推送到堆栈。如果当前字符是'）'和
    //堆栈顶部索引处的字符是“（”，我们只找到一个
    //匹配对从堆栈中弹出。否则，我们将
    //“）”到堆栈。
    //
    //3.扫描完成后，堆栈将仅
    //包含无法匹配的字符的索引。然后
    //让我们在相邻索引之间使用相反的边-子字符串
    //应该是有效的括号。
    //
    //4.如果堆栈为空，则整个输入
    //字符串有效。否则，我们可以扫描堆栈以获得最长的
    //如步骤3所述的有效子字符串。
    public static int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        //记录左边界的位置
        stk.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                //更新左边界
                if (stk.empty()) {
                    stk.push(i);
                } else {
                    ans = Math.max(ans, i - stk.peek());
                }
            }
        }
        return ans;
    }


    public static int longestValidParentheses1(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(')
                    st.pop();
                else
                    st.push(i);
            }
        }
        if (st.empty())
            longest = n;
        else {
            int right=n,left=-1;
            for (Integer num : st) {
                longest = Math.max(longest, num - left - 1);
                left=num;
            }
            longest = Math.max(longest, right - st.peek() - 1);
//            int a = n, b;
//            while (!st.empty()) {
//                b = st.peek();
//                st.pop();
//                longest = Math.max(longest, a - b - 1);
//                a = b;
//            }
//            longest = Math.max(longest, a);
        }
        return longest;
    }

    //DP solution
    public static int DPlongestValidParentheses(String s) {
        char[] S = s.toCharArray();
        //dp[i]表示从s[j到i]匹配的有效括号数（j<i）
        int[] dp = new int[S.length];
        int open = 0, max = 0;

        for (int i = 0; i < S.length; i++) {
            if (S[i] == '('){
                open++;
            }
            if (S[i] == ')' && open > 0) {
                // matches found
                dp[i] = 2 + dp[i - 1];
                // add matches from previous
                if (i - dp[i] > 0)
                    dp[i] += dp[i - dp[i]];
                open--;
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()())"));
        System.out.println(longestValidParentheses("))()())))"));
    }
}
