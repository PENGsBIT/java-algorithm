package 矩阵;

public class 二维矩阵最小路径和 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(a));
    }

    public static int minPathSum(int[][] grid) {
        int[][] sum=new int[grid.length][grid[0].length];
        sum[0][0]=grid[0][0];
        for(int i=1;i<grid[0].length;i++)
        {
            sum[0][i]=sum[0][i-1]+grid[0][i];
        }
        for(int j=1;j<grid.length;j++)
        {
            sum[j][0]=sum[j-1][0]+grid[j][0];
        }

        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                sum[i][j]=Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];

            }
        }
        return sum[grid.length-1][grid[0].length-1];
    }
}
