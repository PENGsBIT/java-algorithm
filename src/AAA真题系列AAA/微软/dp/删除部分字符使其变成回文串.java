package AAA真题系列AAA.微软.dp;

//给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
//输出需要删除的字符个数。例如：s="abca",答案是1.

public class 删除部分字符使其变成回文串 {
    //反序这个字符串，求这个新串和原串的最大子序列。abcda--->adcba
    // 最大子序列是aca，再相减就是最少的字符删除个数。所以问题变成了求两个字符串的最长子序列。
    public int getResult(String s) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s).reverse();
        return s.length() - LCS(s1, s2);
    }
    public int LCS(StringBuilder s1, StringBuilder s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        //如果i=0或j=0,即一个序列长度为0时，那么LCS的长度为0
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
