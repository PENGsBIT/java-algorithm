package 数组;

public class 左下角逆时针打印 {
    public static void main(String[] args) {
        int[][] martix = {
                {9, 8, 7, 6},
                {10, 11, 12, 5},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        int cols = martix[0].length - 1;
        int rows = martix.length - 1;
        ni(martix, rows, cols);
    }



    public static void ni(int[][] matrix, int rows, int cols) {
        int r = cols, l = cols - r, d = rows, u = rows - d;
        while (l <= r && u <= d) {
            if (l == r)
                for (int i = u; i <= d; i++)
                    System.out.println(matrix[i][l]);
            else if (u == d)
                for (int j = l; j <= r; j++)
                    System.out.println(matrix[u][j]);
            else {
                for (int i = l; i < r; i++)
                    System.out.println(matrix[d][i]);
                for (int j = d; j > u; j--)
                    System.out.println(matrix[j][r]);
                for (int k = r; k > l; k--)
                    System.out.println(matrix[u][k]);
                for (int m = u; m <d; m++)
                    System.out.println(matrix[m][l]);
            }
            l++;
            u++;
            d--;
            r--;
        }
    }
}
