package 数学;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-28 17:04
 **/

/**
 * @Author: zpc
 * @Description: n*m棋盘的长方形个数和正方形个数
 * @Create: 2019-07-28 17:04
 **/


public class nm棋盘的长方形个数和正方形个数 {
//x=min(m,n)-1
//长方形里面数正方形的个数计算公式:m*n+(m-1)*(n-1)+.....+(m-x)*(n-x)
// m*n表示长度为1的正方形的个数,(m-1)*(n-1)表示长度为2的正方形的个数。。。。。。
//长方形里面数长方形的个数计算公式(包含正方形):(1+2+3+...+m)*(1+2+3+...+n)=n*m(n+1)*(m+1)/4


    public static int N, M;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        N = 3;
        M = 4;
        int sumz = 0;
        int sumc = 0;
        if (N > M) {
            for (int i = M - 1; i >= 0; i--) {
                sumz += (N - i) * (M - i);
            }
        } else {
            for (int i = N - 1; i >= 0; i--) {
                sumz += (N - i) * (M - i);
            }
        }
        // 长方形个数
        sumc = N * M * (N + 1) * (M + 1) / 4 - sumz;
        System.out.println(sumz + " " + sumc);

    }


}
