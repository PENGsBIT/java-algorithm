package AAA真题系列AAA.微软.dp;

public class 编辑距离Levenshtein {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abdddd";
        int editDistance = levenshtein(s1, s2);
        System.out.println("s1=" + s1 + "与s2=" + s2 + "的编辑距离为：" + editDistance);
    }

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


}
