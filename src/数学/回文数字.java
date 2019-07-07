package 数学;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-07 22:44
 **/

public class 回文数字 {
    public static void main(String[] args) {
        System.out.println(PalindromeNumber(3551));;
    }
    public static boolean PalindromeNumber(int x) {
        //简单的思路 就是把数字逆转，然后判断逆转后的数字跟原来数字是不是一样的
        if (x < 0) return false;
        int r = 0, t= x;
        while (t != 0) {
            r = r * 10 + t % 10;
            t /= 10;
        }
        return r == x;
    }
}
