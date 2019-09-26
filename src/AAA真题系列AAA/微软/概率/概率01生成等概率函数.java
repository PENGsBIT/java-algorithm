package AAA真题系列AAA.微软.概率;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-14 22:41
 **/

import java.util.Random;

/**
 * @Author: zpc
 * @Description:
 * 已知：
 * 有一个随机函数 rand_0_and_1_with_p(), 这个随机数生成器，它能够以概率 p 产生0，以概率 (1 - p) 产生1。
 * 要求：使用这个随机函数，设计一个新的随机函数要求以等概率生成0和1。
 * @Create: 2019-09-14 22:41
 **/


public class 概率01生成等概率函数 {
    //组合问题类型：可以两次调用 该 随机函数。 运行函数 rand_0_and_1_with_p() 一次，
    // 可以得到 P(0) = p, P(1) = 1 - p。那么运行该函数两次，会生成两个数字，
    // P (0 and 1) = p(1 - p)，P(1 and 0) = (1 - p)p。这样就出现了等概率。所以实现如下：
    public static int rand_0_and_1_with_equal_prob() {
        int tmp1 = rand_0_and_1_with_p();
        int tmp2 = rand_0_and_1_with_p();
        if (tmp1 == 0 && tmp2 == 1) {
            return 0;
        } else if (tmp1 == 1 && tmp2 == 0) {
            return 1;
        } else {
            return -1;
        }

    }

    private static int rand_0_and_1_with_p() {
        Random ra = new Random();
        return ra.nextInt();
    }

}
