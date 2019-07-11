package 矩阵;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-11 23:06
 **/

public class 矩阵的最小路径和 {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        };
        System.out.println(minPath(matrix));

    }

    public static int minPath(int[][] matrix) {
        int[]dp=new int[matrix[0].length+1];
        int row=matrix.length,col=matrix[0].length;
        dp[0] = matrix[0][0];
        //计算第一行的最短路径
        for(int j = 1; j < col; j++)
        {
            dp[j] = dp[j-1] + matrix[0][j];
        }
        //计算除了第一行的其它最小路径和
        for(int i = 1; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(j == 0)
                {
                    dp[j] += matrix[i][j];
                }
                else
                {
                    dp[j] =Math.min(dp[j-1], dp[j]);
                    dp[j] += matrix[i][j];
                }
            }//for
        }//for

        return dp[col - 1];
    }
}
