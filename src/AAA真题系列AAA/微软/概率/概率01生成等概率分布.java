package AAA真题系列AAA.微软.概率;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-14 22:41
 **/

import java.util.Random;

/**
 * @Author: zpc
 * @Description:已知：
 * 有一个随机函数 rand_0_and_1_with_p(), 这个随机数生成器，它能够以概率 p 产生0，以概率 (1 - p) 产生1。
 * 要求：使用这个随机函数 rand_0_and_1_with_p()，设计一个新的随机函数，要求以等概率产生 1  到 n 之间的随机数。
 * @Create: 2019-09-14 22:41
 **/


public class 概率01生成等概率分布 {
    //我们现在已经有了 （0， 1）的等概率随机数生成器。给定一个n，我们不妨将 (0, 1)等概率随机数生成器生成的0， 1 看作是二进制。
    // 那么我们多云行几次，就可以生成一个二进制数字，如果这个二进制数字有 Log2(n) 个比特位。就可以了。
    //这里要注意，可能生成的数字会超过n，此时这里要舍弃这次随机数生成，重新再来一次。
    public static int rand_0_to_n_minus_1_with_equal_prob(int n) {
        int digit = 0,temp=n;
        while(temp!=0) {
            digit++;
            temp = temp >> 1;
        }
        int res = 0;
        do {
            res = 0;
            for(int i = 0; i < digit; i++){
                res |= rand_0_and_1_with_equal_prob() << i;
            }
        } while(res >= n);

        return res;
    }

    public static int rand_0_and_1_with_equal_prob() {
        int tmp1 = rand_0_and_1_with_p();
        int tmp2 = rand_0_and_1_with_p();
        if (tmp1 == 0 && tmp2 == 1) {
            return 0;
        } else if (tmp1 == 1 && tmp2 == 0) {
            return 1;
        } else {
            return rand_0_and_1_with_equal_prob();
        }

    }

    private static int rand_0_and_1_with_p() {
        Random ra = new Random();
        return ra.nextInt(2);
    }

    public static void main(String[] args) {
        System.out.println(rand_0_to_n_minus_1_with_equal_prob(3));
    }
}
