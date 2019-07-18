package 转化;

public class 正则表达式匹配 {
    //dp求解 dp[i][j] to be true if s[0..i) matches p[0..j)
    public static boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        //pattern从第一位判断是不是*
        for (int j = 1; j <= n; j++)
            if (pattern[j - 1] == '*')
                dp[0][j] = dp[0][j - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }

    //递归求解
    public static boolean MatchDG(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) {
            if (p.length()==2&&p.charAt(1)=='*') {
                return true;
            }else {
                return false;
            }
        }
        if (p.length() == 1) {
            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }
        //if the next character in pattern is not '*'
        if (p.charAt(1) != '*') {
            if (s.charAt(0) == p.charAt(0) ||  p.charAt(0) == '.')
                //相等或者P有.与S相等时，都向后移动一位
                return MatchDG(s.substring(1), p.substring(1));
            else
                return false;
        }
        //if the next character is '*'
        else {
            if (s.charAt(0) == p.charAt(0) ||  p.charAt(0) == '.')
                //判断*代表至少复制一次用sub判断是否该结束循环
                return MatchDG(s, p.substring(2)) || MatchDG(s.substring(1), p);
            else
                //判断*代表复制0次
                return MatchDG(s, p.substring(2));
        }
    }

    public static boolean rexMatch(char[] str) {
        String str1 = String.valueOf(str);
        return str1.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println(match("aaa".toCharArray(),"ab*ac*a".toCharArray()));
        System.out.println(match("aaa".toCharArray(),"aa.a".toCharArray()));
        System.out.println();
        //System.out.println(MatchDG("aaa","ab*ac*a"));
        System.out.println(MatchDG("aa","b*a"));
        System.out.println(MatchDG("a","ab*a"));
        System.out.println();

        System.out.println(rexMatch("-1E-16".toCharArray()));
        System.out.println(rexMatch("1a3.14".toCharArray()));
    }
}
