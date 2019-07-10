package 矩阵;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] a = {
                {1,2,3,4},
                {2,3,4,5},
                {3,4,5,6},
        };
        //System.out.println(a[0]);
        System.out.println(searchMatrix(a,6));
    }



    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
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
