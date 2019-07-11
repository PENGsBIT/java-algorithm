package 矩阵;
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
// 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
// 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

public class 机器人的运动范围 {
//地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
    public static void main(String[] args) {
        机器人的运动范围 b = new 机器人的运动范围();
        System.out.println(b.getrange(3, 3, 3));
    }

    public int getrange(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return countMoving(0, 0, rows, cols, flag, threshold);
    }

    private int countMoving(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return countMoving(i - 1, j, rows, cols, flag, threshold)
                + countMoving(i + 1, j, rows, cols, flag, threshold)
                + countMoving(i, j - 1, rows, cols, flag, threshold)
                + countMoving(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }


}





