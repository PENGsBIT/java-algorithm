package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-11 21:09
 **/

import java.util.Scanner;

/**
 * @Author: zpc
 * @Description: bytedance 2
 * @Create: 2019-08-11 21:09
 **/

//n位的x右移0,1...k-1位一起异或，获得结果string求x
//例如：7 4
//1110100110
//x=1001010
//1001010^
// 1001010^
//  1001010^
//   1001010^
//===========
//1110100110
public class 右移异或 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int k = sca.nextInt();
        String str = sca.next();
        decode(str, n, k);
    }

    private static void decode(String str, int n, int k) {
        char[] c = str.toCharArray();
        char[] res = new char[n];
        res[0] = c[0];
        int cur = 1;
        while (cur <= n - 1) {
            int step = 1;
            res[cur] = c[cur];
            while (cur - step >= 0 && step < k) {
                int a = Character.getNumericValue(res[cur]);
                int b = Character.getNumericValue(res[cur - step]);
                a ^= b;
                res[cur] = (char) (a + '0');
                step++;
            }
            cur++;

        }
        System.out.println(res);
    }
}
