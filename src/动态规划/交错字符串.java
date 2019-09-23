package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 15:43
 **/

/**
 * @Author: zpc
 * @Description: leetcode97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * @Create: 2019-09-23 15:43
 **/


public class 交错字符串 {
    //dp
    public boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length(), len2 = s2.length();
        if(s3.length() != len1 + len2){
            return false;
        }
        //考虑用 s1 和 s2 的某个前缀是否能形成 s3 的一个前缀。
        //dp[i][j] 表示用 s1 的前 (i+1) 和 s2的前 (j+1)个字符，
        // 总共 (i+j+2) 个字符，是否交错构成 s3的前缀。
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        //s1前缀
        for(int i = 1; i <= len1; i++){
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        //s2前缀
        for(int i = 1; i <= len2; i++){  //base case, go right
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //case 1, special case, up and left has the same character.
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    //case2, normal case, only from left
                }else if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                    //case3, normal case, only from up
                }else if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];

    }
    //dfs
    public boolean DFSisInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid =
                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}
