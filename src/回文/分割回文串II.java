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


public class 分割回文串II {
    public static int minCut(String s) {
        int n = s.length();
        int[]cut=new int[n+1];  // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) cut[i] = i-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j)==s.charAt(i+j) ; j++) // odd length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j]);

            for (int j = 1; i-j+1 >= 0 && i+j < n && s.charAt(i-j+1) == s.charAt(i+j); j++) // even length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);
        }
        return cut[n];
    }


//    This can be solved by two points:
//
//    cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
//    If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
//    The 2nd point reminds us of using dp (caching).
//
//    a   b   a   |   c  c
//    j  i
//    j-1  |  [j, i] is palindrome
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
