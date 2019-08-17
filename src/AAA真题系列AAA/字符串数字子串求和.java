package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-17 14:54
 **/

/**
 * @Author: zpc
 * @Description: zoom1
 * @Create: 2019-08-17 14:54
 **/

//A-1BC--12    the number is -1,12 and the sum is 11
//
//A-1BC--2C--D6E  the number is -1,2,6 and the sum is 7
public class 字符串数字子串求和 {
    private static int sumNumInStr(String str) {
        char[] s = str.toCharArray();
        //num表示当前收集到的数字
        int sum = 0, num = 0;
        boolean flag = true;//判断当前是正负
        int cur;
        for (int i = 0; i <s.length ; i++) {
            cur = s[i]-'0';
            //处理非数字
            if (cur < 0 || cur > 9) {
                sum += num;
                num = 0;
                if (s[i] == '-') {
                    if (i - 1 >= 0 && s[i - 1] == '-') {
                        flag = !flag;
                    } else {
                        flag = false;
                    }
                } else {
                    flag = true;
                }
            } else {
                num = num * 10 + cur * (flag ? 1 : -1);
            }
        }
        sum += num;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumInStr("A-1BC--12"));
    }
}
