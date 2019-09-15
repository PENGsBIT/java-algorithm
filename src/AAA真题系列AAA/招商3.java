package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-15 22:32
 **/

/**
 * @Author: zpc
 * @Description:
 * 给你一个由数字（0,9）和？组成的字符串，问你有几种情况该字符串模13余5，可以有前缀零，如果答案过大，则对1e9+7取模。
 * Sample Input 1 Copy
 * ??2??5
 * Sample Output 1 Copy
 * 768
 * For example, 482305,002865,482305,002865, and 972665972665 satisfy the condition.


 * @Create: 2019-09-15 22:32
 **/


public class 招商3 {
    public static int maxn = (int) 1e5;
    public static int MOD = (int) 1e9+7;
    public static int[][] dp = new int[maxn][13];
//  dp[100005][13],dp[i][j]表示到第i个字符为止，除以13余j(j表示的是到i-1为止模13余j)有多少中情况
// 若当前字符为数字，则递推公式dp[i][(j*10+s[i])%13] = (dp[i][(j*10+s[i])%13] + dp[i-1][j])%mod;
// 若当前字符为？，则递推公式dp[i][(j*10+k)%13] = (dp[i][(j*10+k)%13] + dp[i-1][j])%mod;  (k从0到9，假设当前字符为k)
// 该过程就是模拟某个数模13余几的过程，比如：567%13 -> 5%13=5 , (5*10+6)%13=4 , (4*10+7)%13=8
    public static void findDigitsParade(String s) {
        int n = s.length();
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            //不是？
            if (s.charAt(i) != '?') {
                //t为当前数字
                int t = s.charAt(i) - '0';
                for (int j = 0; j < 13; j++) {
                    dp[i + 1][(j * 10 + t) % 13] = (dp[i][j] + dp[i + 1][(j * 10 + t) % 13]) % MOD;
                }
            } else {
                //是？
                //j为前一位的余数
                for (int j = 0; j < 13; j++) {
                    //?可以代替0-9则遍历0-9
                    for (int k = 0; k < 10; k++) {
                        dp[i + 1][(j * 10 + k) % 13] = (dp[i][j] + dp[i + 1][(j * 10 + k) % 13]) % MOD;
                    }
                }
            }
        }
        System.out.println(dp[n][5]);
    }
    public static void main(String[] args) {
        findDigitsParade("??2??5");
    }
}
