package AAA真题系列AAA.微软.dp;

import java.util.Stack;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
public class MaximalRectangle最大矩阵 {
    public static void main(String[] args) {
        char[][] a = {
                {'1', '0', '1', '0', '0'},
                {'0', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(a));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[] height = new int[matrix[0].length + 1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            res = Math.max(res, largestRectangle(height));
        }
        return res;
    }

    private static int largestRectangle(int[] height) {
        int i = 0, res = 0;
        height[height.length - 1] = 0;
        Stack<Integer> s = new Stack<Integer>();
        while (i < height.length) {
            if (s.isEmpty() || height[i] >= height[s.peek()])
                s.push(i++);
            else
                res = Math.max(res, height[s.pop()] * (s.isEmpty() ? i : i - s.peek() - 1));
        }
        return res;
    }
}
