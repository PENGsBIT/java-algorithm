package 矩阵;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-18 11:28
 **/

/**
 * @Author: zpc
 * @Description: 矩阵中的最长上升路径
 * 给定整数矩阵，找到最长增加路径的长度。
 * 从每个单元格，您可以移动到四个方向：左，右，上或下。 您不能沿对角线移动或移动到边界外
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * @Create: 2019-08-18 11:28
 **/


public class 矩阵中的最长上升路径 {
    private static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
}
