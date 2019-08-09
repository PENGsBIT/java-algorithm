package 回文;
//leetcode 132. 分割回文串 II
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//返回符合要求的最少分割次数。
//
//示例:
//
//输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//

import java.util.stream.IntStream;

public class 分割回文串II {
    //“cut”数组的定义是子字符串的最小切割数。更具体地说，cut[n]存储字符串s[0，n-1]的切割数。
    //解决方案的基本思想如下：
    //初始化“cut”数组：对于具有n个字符s[0，n-1]的字符串，最多需要n-1个cut。因此，“cut”数组初始化为cut[i]=i-1
    //在两个循环中使用两个变量来表示回文：
    //外部循环变量“i”表示回文的中心。内部循环变量“j”表示回文的“半径”。显然，我是必须的。
    //这个回文可以表示为s[i-j，i+j]。如果这个字符串确实是回文，那么cut[i+j]的一个可能值是cut[i-j]+1，
    // 其中cut[i-j]对应s[0，i-j-1]，1对应回文[i-j，i+j]；
    //当循环结束时，您将在切割处得到答案[s.length]
    public static int minCut(String s) {
        // validate input
        if (s == null || s.length() <= 1) {
            return 0;
        }
        // dp
        int N = s.length();
        int[] dp = IntStream.range(0, N).toArray(); // initial value: dp[i] = i

        for (int mid = 1; mid <  N; mid++) { // iterate through all chars as mid point of palindrome
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[N - 1];
    }


//    这可以通过两点来解决：
//      1.如果[j，i]是回文，则cut[i]是cut[j-1]+1（j<=i）的最小值。
//      2.如果[。j+1，i-1]是回文，c[j]==c[i]，则[j，i]是回文
//    The 2nd point reminds us of using dp (caching).
//
//    a   b   a   |   c  c
//                    j  i
//           j-1  |  [j, i] is palindrome
//    cut(j-1) +  1


    public static int minCut1(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut1("aab"));
    }
}
