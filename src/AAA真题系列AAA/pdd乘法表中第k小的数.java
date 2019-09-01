package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-01 17:03
 **/

/**
 * @Author: zpc
 * @Description: 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * @Create: 2019-09-01 17:03
 **/


public class pdd乘法表中第k小的数 {
    public static int findKthNumber(int m, int n, int k) {
        int low = 1 , high = m * n + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c >= k) high = mid;
            else low = mid + 1;
        }
        return high;
    }

    private static int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i , n);
            count += temp;
        }
        return count;
    }

    public static void main(String[] args) {
        //small
        System.out.println(findKthNumber(3,3,3));
        //largest
        System.out.println(findKthNumber(3,3,3*3-3));

    }
}
