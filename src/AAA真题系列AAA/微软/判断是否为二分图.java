package AAA真题系列AAA.微软;

import java.util.Arrays;

public class 判断是否为二分图 {
    public static void main(String[] args) {
        判断是否为二分图 判断是否为二分图 = new 判断是否为二分图();
        boolean b = 判断是否为二分图.isBipartite(new int[][] {
            // 0----1
            //|    |
            //|    |
            //3----2--4--5
            { 1, 3 },
            { 0, 2 },
            { 1, 3, 4 },
            { 0, 2 },
            { 2, 5 },
            { 4 }
        });

        int[][] matrix = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 }
        };
        System.out.println(b);
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && dfs(i, 0, colors, graph) == false) {
                return false;
            }
        }
        return true;
    }
    //longestSubStr table
    private boolean dfs(int curNode, int curcolor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curcolor;
        }
        colors[curNode] = curcolor;
        for (int nextNode : graph[curNode]) {
            if (!dfs(nextNode, 1 - curcolor, colors, graph)) {
                return false;
            }
        }
        return true;
    }
    //longestSubStr matrix
    private static boolean dfs(int curNode, int curColor, int[][] matrix, int[] colors) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curColor;
        }
        colors[curNode] = curColor;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[curNode][i] == 1 && dfs(i, 1 - curNode, matrix, colors)==false) {
                return false;
            }
        }
        return true;
    }
}
