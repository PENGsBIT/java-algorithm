package 转化;

public class 回文manacger {


    public static void main(String[] args) {
        //String str = "abcdcbafabcdck";
        String str = "acbdbceds";
        System.out.println(searchPalindrome(str));
        System.out.println(manacher(str));
        System.out.println(longestPalindrome(str));
    }

    //O(n) Manacher
    public static char[] manacherString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static int manacher(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        //使用“#”字符处理之后的新字符串 #a#c#b#d#b#c#e#d#s#
        char[] charArr = manacherString(str);
        //回文半径数组radius是用来记录以每个位置的字符为回文中心求出的回文半径长度
        int[] radius = new int[charArr.length];
        //最右回文右边界R
        //一个位置最右回文右边界指的是这个位置及之前的位置的回文子串，所到达的最右边的地方。
        int R = -1;
        //最右回文右边界的对称中心C
        int c = -1;

        int max = Integer.MIN_VALUE;
//        首先大的方面分为两种情况：
//        第一种情况：下一个要移动的位置在最右回文右边界R的右边。
//        比如在最开始时，R=-1,p的下一个移动的位置为p=0，p=0在R=-1的右边；p=0时，此时的R=0，p的下一个移动位置为p=1，也在R=0的右边。
//        在这种情况下，采用普遍的解法，将移动的位置为对称中心，向两边扩，同时更新回文半径数组，最右回文右边界R和最右回文右边界的对称中心C。
//        第二种情况：下一个要移动的位置就是最右回文右边界R或是在R的左边
//        1、下一个要移动的位置p1不在最右回文右边界R右边，且cL<pL。
//        2、下一个要移动的位置票p1不在最右回文右边界R的右边，且cL>pL。
//        3、下一个要移动的位置票p1不在最右回文右边界R的右边，且cL=pL；

        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2 * c - i], R - i + 1) : 1;
            while (i + radius[i] < charArr.length && i - radius[i] > -1) {
                if (charArr[i - radius[i]] == charArr[i + radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > R) {
                R = i + radius[i] - 1;
                c = i;
            }
            max = Math.max(max, radius[i]);
        }
        return max - 1;
    }

    public static String mana(String s) {
        if (s == null || s.length() <= 1)
            return s;
        StringBuilder sb = new StringBuilder("$#");

        for (int i = 0; i < s.length(); i++) {
            sb.append(String.valueOf(s.charAt(i)));
            sb.append("#");
        }
        char[] str = sb.toString().toCharArray();
        int[] r = new int[str.length];
        int mx = 0, id = 0, ansR = 0, ansCenter = 0;
        for (int i = 1; i < str.length; i++) {
            r[i] = mx - i > r[i] ? Math.min(r[2 * id - i], mx - i) : 1;
            while (i - r[i] >= 0 && i + r[i] < str.length
                && str[i - r[i]] == str[i + r[i]]) {
                r[i]++;
            }
            if (i + r[i] > mx) {
                mx = i + r[i];
                id = i;
            }
            if (ansR < r[i]) {
                ansR = r[i];
                ansCenter = i;
            }
        }
        int maxStart = (ansCenter - ansR + 1) / 2;
        return s.substring(maxStart, maxStart + ansR - 1);
    }

    //O(n2) dp
    public String dp(String s) {
        if(s == null || s.length() < 2) return s;
        int len = s.length();
        int dp[] = new int[len];
        int startIndex = 0, endIndex = 0;
        for(int j = 1; j < len; ++j){
            for(int i = 0; i < j; ++i){
                dp[i] = dp[i + 1] == 0 && s.charAt(i) == s.charAt(j) ? 0 : 1;
                if(dp[i] == 0 && (j - i) > (endIndex - startIndex)){
                    endIndex = j;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
    //O(n2)
    //中心扩展法
    private static int maxLen = 0;
    private static String sub = "";

    public static String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {

            findLongestPalindrome(s, i, i);//单核回文

            findLongestPalindrome(s, i, i + 1);//双核回文
        }
        return sub;
    }
    public static void findLongestPalindrome(String s, int low, int high) {
        while (low >= 0 && high <= s.length() - 1) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                low--;//向两边扩散找当前字符为中心的最大回文子串
                high++;
            } else
                break;
        }
    }

    //O(n3) search
    public static String searchPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = s.length(); i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);//子串位置
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1)) {
                        count++;
                    }
                }
                if (count == sub.length() / 2) {
                    return sub;
                }
            }
        }
        return "";//表示字符串中无回文子串

    }

}