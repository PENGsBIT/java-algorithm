package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-21 12:00
 **/

/**
 * @Author: zpc
 * @Description: 圆环回原点
 * @Create: 2019-07-21 12:00
 **/


public class 圆环回原点 {
    //d(k, j)表示从点j 走k步到达原点0的方法数，因此可以转化为他相邻的点经过k-1步回到原点的问题，
    // 这样将问题的规模缩小.d(k, j) = d(k-1, j-1) + d(k-1, j+1);
    // 由于是环的问题， j-1, j+1可能会超出 0到n-1的范围
    //递推式d(k, j) = d(k-1, (j-1+n)%n) + d(k-1, (j+1)%n);
    public static int backToZero(int N,int K) {
        //N代表N个点记做0,1,2..N-1
        //K代表K步
        if (N <= 1) {
            throw  new IllegalArgumentException();
        }
        if (N == 2) {
            if (K % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int[][] dp = new int[K+1][N+1];
        dp[0][0]=1;
        for (int k = 1; k <=K ; k++) {
            for (int n = 0; n <N ; n++) {
                dp[k][n] = dp[k - 1][(n - 1 + N) % N] + dp[k - 1][(n + 1+N) % N];
            }
        }
        return dp[K][0];
    }

    public static void main(String[] args) {
        System.out.println(backToZero(10, 2));
    }

    //如果K<N则可以转换成求排列组合问题， 比如N == 6， 则必然有3步向前，3步后退， 无关顺序，
    // 所以只要选3个位置存放向前即可，组合共有6*5*4 / 3/2 =  20种方案
    static Integer findNumber(Integer N){

        if (N == 0 || N %2 == 1){
            return 0;
        }
        Integer Number = travel(N - 10, N);
        return Number;
    }

    static Integer travel(Integer needInsert, Integer N){
        if (needInsert <0){
            return calcu(N, N/2);
        }else if (needInsert == 0){
            return calcu(N, N/2) + 2;
        }else if (needInsert % 10 == 0){
            return 2 * calcu(N, needInsert/2) + travel(needInsert -10, N) + 2;
        }else {
            return 2 * calcu(N, needInsert/2) + travel(needInsert -10, N);
        }
    }

    static Integer calcu(Integer n, int i) {
        int number = 1;
        int temp = 1;
        while(i >0){
            number = number * (n-i +1);
            temp = temp * i;
            i--;
        }
        return number / temp;
    }

}
