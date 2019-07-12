package 矩阵;

import java.util.Arrays;

public class 矩阵的总路径数 {
    public static void main(String[] args) {
        System.out.println(sumTotalPath(3,3));;
    }
    //dp 初始化dp为第一行列，只有一个路径，然后不停的在每一行叠加
    public static int sumTotalPath(int rows, int cols) {
        int []dp=new int[cols];
        Arrays.fill(dp, 1);
        for (int i = 1; i <rows ; i++) {
            for (int j = 1; j <cols ; j++) {
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[cols-1];
    }
}
