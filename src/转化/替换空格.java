package 转化;

public class 替换空格 {
    //将一个字符串中的空格替换成 "%20"。
    public static void main(String[] args) {
        System.out.println(replaceSpace("  A B " ));
    }
    public static String replaceSpace(String str) {
        return str.replace(" ","%20");
    }
    public String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
