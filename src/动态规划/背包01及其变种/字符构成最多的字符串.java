package 动态规划.背包01及其变种;

public class 字符构成最多的字符串 {
//    Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//    Output: 4
//
//    Explanation: There are totally 4 strings can be formed by the using of 5 '0' and 3 '1', which are "10","0001","1","0"
    public static int findMaxForm(String[]strs,int m,int n){
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int one=0, zero=0;
            for (char c :str.toCharArray()) {
                if (c=='1'){
                    one++;
                }
                else zero++;
            }
            for (int i = m; i >=zero ; i--) {
                for (int j = n; j >=one  ; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zero][j-one]+1);
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
        System.out.println(findMaxForm(new String[]{"10", "0", "1"},1,1));
    }
}
