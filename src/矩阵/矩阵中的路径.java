package 矩阵;

public class 矩阵中的路径 {
    // * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。 路径可以从矩阵中任意一格开始 每一步可以在矩阵中间向左、右、上、下移动一格。
    // * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
            { 'a', 'b', 'c', 'd' },
            { 'b', 'c', 'd', 'a' },
            { 'c', 'd', 'a', 'b' }
        };

        char str[] = { 'a', 'b', 'c', 'd' };
        boolean b = hasPath(matrix, str);
        System.out.println(b);

    }

    /**
     * *
     *
     * @param matrix 输入矩
     * @param str    查询路径
     * @return
     */
    private static boolean hasPath(char[][] matrix, char[] str) {
        // 参数检验
        if (matrix == null || str == null) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 变量初始化，没有访问过为false 访问过为true
        boolean[][] visited = new boolean[rows][cols];

        // 记录结果，数量
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPath(matrix, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }
        return false;

    }
    //回溯法
    /**
     *  * 
     *  * @param matrix
     *  * @param str
     *  * @param visited
     *  * @param i
     *  * 当前行数
     *  * @param j
     *  * 当前列数
     *  * @param pathLength
     *  * @return
     *  
     */
    private static boolean findPath(char[][] matrix, char[] str, boolean[][] visited, int i, int j, int pathLength) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (i >= 0 && i < m && j >= 0 && j < n && matrix[i][j] == str[pathLength] && visited[i][j] == false) {
            visited[i][j] = true;
            pathLength++;
            // 找到以后，递归去找一下个
            hasPath = findPath(matrix, str, visited, i, j - 1, pathLength)
                || findPath(matrix, str, visited, i - 1, j, pathLength)
                || findPath(matrix, str, visited, i, j + 1, pathLength)
                || findPath(matrix, str, visited, i + 1, j, pathLength);
            if (!hasPath) {
                pathLength--;
                visited[i][j] = false;
            }
        }
        return hasPath;
    }

}
