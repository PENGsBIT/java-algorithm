public class 回文manacger {
    public static void main(String[] args) {
        //String str = "abcdcbafabcdck";
        String str = "acbdbceds";
        System.out.println(manacher(str));
    }

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        return max-1;
    }

    public String longestPalindrome(String s) {
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
            while (i - r[i] >= 0 && i + r[i]< str.length
                    && str[i - r[i]] == str[i + r[i]])
                r[i]++;
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
}
