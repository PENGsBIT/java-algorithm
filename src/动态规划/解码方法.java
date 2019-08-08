package 动态规划;

//leetcode 91. 解码方法
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//示例 1:
//
//输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//示例 2:
//
//输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//

public class 解码方法 {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //dp[i]表示s从0开始，长度为i的子串的解码方式数量
        int[] dp = new int[n+1];
        //dp[0]表示空字符串有一种解码方式，dp[1]表示对大小为1的字符串进行解码的方式。
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            //枚举最后一个字母对应1位还是2位，将f转化为规模更小的子问题。
            int restOne = Integer.valueOf(s.substring(i-1, i));
            int restTWO = Integer.valueOf(s.substring(i-2, i));
            if(restOne >= 1 && restOne <= 9) {
                dp[i] += dp[i-1];
            }
            if(restTWO >= 10 && restTWO <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("216"));;
        System.out.println(numDecodings("1025"));
    }
}
