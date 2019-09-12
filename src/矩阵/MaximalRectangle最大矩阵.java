package 矩阵;

import java.util.Stack;
//leetcode 85. 最大矩形
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//示例:
//
//输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6
//
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
