package 图;

import java.util.Arrays;

public class 判断是否为二分图 {
    public static void main(String[] args) {
        判断是否为二分图 判断是否为二分图 = new 判断是否为二分图();
        boolean b = 判断是否为二分图.isBipartite(new int[][]{
                // 0----1
                //|    |
                //|    |
                //3----2
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2},
                {}
        });
        System.out.println(b);
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1 && dfs(i, 0, colors, graph)==false) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curNode, int curcolor, int[] colors, int[][] graph) {
        if (colors[curNode] != -1) {
            return colors[curNode] == curcolor;
        }
        colors[curNode] = curcolor;
        for (int nextNode : graph[curNode]
        ) {
            if (!dfs(nextNode, 1 - curcolor, colors, graph)) {
                return false;
            }
        }
        return true;
    }
}
