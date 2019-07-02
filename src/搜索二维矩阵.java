public class 搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix={
        {1,   3,  5,  7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };
        System.out.println(searchMatrix(matrix,16));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid/n);
            System.out.println(mid%n);
            if (matrix[mid/n][mid%n] == target) {
                return true;
            } else if (matrix[mid/n][mid%n] < target) {
                left = mid + 1;
            } else if (matrix[mid/n][mid%n] > target) {
                right = mid - 1;
            }
        }
        return false;

    }
}
