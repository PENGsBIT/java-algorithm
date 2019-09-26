package 回文;

//leetcode 516. 最长回文子序列
//给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
//
//示例 1:
//输入:
//
//"bbbab"
//输出:
//
//4
//一个可能的最长回文子序列为 "bbbb"。
//
//示例 2:
//输入:
//
//"cbbd"
//输出:
//
//2
//一个可能的最长回文子序列为 "bb"。
//

public class 最长回文子序列 {
    //dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
    //    State transition:
    //    dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
    //    otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
    //    Initialization: dp[i][i] = 1
    //原题相当于，原字符串s与倒置后所得字符串_s，计算两个字符串的最长公共子序列。
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
