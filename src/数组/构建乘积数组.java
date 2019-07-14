package 数组;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 13:31
 **/

public class 构建乘积数组 {
    //给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，
    // 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}
