package 动态规划;

public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    res[j] = res[j];// 只能从上侧走到该位置
                }
                else if (i == 0) {
                    res[j] = res[j-1];// 只能从左侧走到该位置
                } else
                    res[j] = Math.min(res[j], res[j - 1]);
                res[j] += grid[i][j];
            }
        }
        return res[m-1];
    }
}
