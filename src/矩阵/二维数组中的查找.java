package 矩阵;

public class 二维数组中的查找 {
    //给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
    public static void main(String[] args) {
        int[][] a = new int[][] {
            { 1, 4, 7, 11, 15 },
            { 2, 5, 8, 12, 19 },
            { 3, 6, 9, 16, 22 },
            { 10, 13, 14, 17, 24 },
            { 18, 21, 23, 26, 30 }
        };
        findTarget(16,a);
    }
    public static boolean findTarget(int target, int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        //// 从右上角开始
        int i=0,j=matrix[0].length-1;
        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target == matrix[i][j]) {
                return true;
            } else {
                j--;
            }
        }
        return false;
    }
}
