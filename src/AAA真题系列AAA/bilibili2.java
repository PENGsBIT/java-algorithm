package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-10 19:47
 **/

import java.util.Scanner;

/**
 * @Author: zpc
 * @Description: leetcode829
 * @Create: 2019-09-10 19:47
 **/


public class bilibili2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        long n = sca.nextLong();
        int res = 0;
        for (int i = 1; ; i++) {
            long temp = n - i * (i - 1) / 2;
            if (temp <= 0) {
                break;
            }
            if (temp % i == 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
