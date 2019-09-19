package 数学;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-19 11:14
 **/

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-19 11:14
 **/


public class 素数判断 {
    //总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数。
    //    如何论证这个结论呢，其实不难。首先 6x 肯定不是质数，因为它能被 6 整除；
    // 其次 6x+2 肯定也不是质数，因为它还能被2整除；依次类推，6x+3 肯定能被 3 整除；
    // 6x+4 肯定能被 2 整除。那么，就只有 6x+1 和 6x+5 (即等同于6x-1) 可能是质数了。
    // 所以循环的步长可以设为 6，然后每次只判断 6 两侧的数即可。

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;

    }
}
