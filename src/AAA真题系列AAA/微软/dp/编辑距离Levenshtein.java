package AAA真题系列AAA.微软.dp;

//leetcode 72. 编辑距离
//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符
//示例 1:
//
//输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//示例 2:
//
//输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释:
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//

import java.util.Arrays;

public class 编辑距离Levenshtein {

    /**
     * 编辑距离求解
     * @param s1 字符串s1
     * @param s2 字符串s2
     * @return 编辑距离
     */
    private static int levenshtein(String s1, String s2) {
        int m = s1.length();    //s1字符串长度
        int n = s2.length();    //s2字符串长度
        if (m == 0) {   //s1字符串长度为0，此时的编辑距离就是s2字符串长度
            return n;
        }
        if (n == 0) {
            return m;   //s2字符串长度为0，此时的编辑距离就是s1字符串长度
        }
//        对于边界情况，i=0代表word1为空，故由word1插入j个字符可转化为word2，即dp[0][j] = j。同理，dp[i][0] = i
        int[][] solutionMatrix = new int[m + 1][n + 1];     //求解矩阵
        /**
         *      d e f
         *   |0|x|x|x|
         * a |1|x|x|x|
         * b |2|x|x|x|
         * c |3|x|x|x|
         */
        for (int i = 0; i <= m; i++) {
            solutionMatrix[i][0] = i;
        }
        /**
         *      d e f
         *   |0|1|2|3|
         * a |x|x|x|x|
         * b |x|x|x|x|
         * c |x|x|x|x|
         */
        for (int j = 0; j <= n ; j++) {
            solutionMatrix[0][j] = j;
        }
        /**
         * 上面两个操作后，求解矩阵变为
         *      d e f
         *   |0|1|2|3|
         * a |1|x|x|x|
         * b |2|x|x|x|
         * c |3|x|x|x|
         * 接下来就是填充剩余表格
         */
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                //当相同的时，dp[i][j] = dp[i - 1][j - 1]
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    solutionMatrix[i][j] = solutionMatrix[i - 1][j - 1];
                } else {
                    //当不同的时候，我们需要求三种操作的最小值
                    //其中dp[i - 1][j - 1]表示的是替换，dp[i - 1][j]表示删除字符，do[i][j - 1]表示的是增加字符
                    solutionMatrix[i][j] = 1 + Math.min(solutionMatrix[i - 1][j - 1], Math.min(solutionMatrix[i - 1][j], solutionMatrix[i][j - 1]));
                }
            }
        }
        return solutionMatrix[m][n];
    }
    //o(n)Note that each time when we update dp[i][j], we only need dp[i - 1][j - 1], dp[i][j - 1] and dp[i - 1][j].
    // We may optimize the space of the code to use only two vectors.
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n + 1];
        int[] cur = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            pre[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur[j] = pre[j - 1];
                } else {
                    cur[j] = Math.min(pre[j - 1], Math.min( pre[j],cur[j - 1])) + 1;
                }
            }
            Arrays.fill(pre, 0);
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n];
    }
    public static int minDistanceOneArray(String word1, String word2) {
        int opt[] = new int[word2.length()+1];
        // base case
        for(int j = 0;j <= word2.length();j++) opt[j] = j;
        // iteration
        for(int i = 1;i <= word1.length();i++){
            int pre = i, corner = i-1;
            for(int j = 1;j <= word2.length();j++){
                int temp = corner;
                corner = opt[j];
                temp += (word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                opt[j] = Math.min(temp,Math.min(opt[j],pre)+1);
                pre = opt[j];
            }
            opt[word2.length()] = pre;
        }
        return opt[word2.length()];
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abdddd";
        int editDistance = levenshtein(s1, s2);
        System.out.println("s1=" + s1 + "与s2=" + s2 + "的编辑距离为：" + editDistance);
        System.out.println(minDistance(s1,s2));
        System.out.println(minDistanceOneArray(s1,s2));
    }
}
