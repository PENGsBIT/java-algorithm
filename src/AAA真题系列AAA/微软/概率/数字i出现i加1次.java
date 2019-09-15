package AAA真题系列AAA.微软.概率;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-14 23:03
 **/

import java.util.Random;

/**
 * @Author: zpc
 * @Description:问题: 如何得到可以产生如下概率的随机数？ 0出现1次，1出现2次，2出现3次，n-1出现n次。
 * @Create: 2019-09-14 23:03
 **/


public class 数字i出现i加1次 {
    //我们注意到有如下规律：n - 1 = (n - 1) + 0 = (n - 2) + 1 = (n - 3) + 2 = ... =
    // 2 + (n - 3) = 1 + (n - 2) = 0 + (n - 1)
    //可以发现，满足a + b = n - i的(a, b)数对的个数为n - i + 1个
    public static Random ra = new Random();
    public static int randi(int n) {
        while(true) {
            int tmp1 = ra.nextInt(n+1) % n;
            int tmp2 = ra.nextInt(n+1) % n;
            if(tmp1 + tmp2  < n) {
                return tmp1 + tmp2;
            }
        }
    }

    public static void main(String[] args) {
        int i=0;
        while (i++ < 20) {
            System.out.println(randi(5));
        }

    }

}
