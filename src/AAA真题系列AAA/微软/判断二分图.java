package AAA真题系列AAA.微软;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-31 21:05
 **/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zpc
 * @Description: 785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 *
 * @Create: 2019-08-31 21:05
 **/


public class 判断二分图 {
    private static int[][]nodes;
    private static int[]colors;
    //DFS Solution
    public static boolean isBipartite(int[][] graph) {
        nodes = graph;
        int n = graph.length;
        colors = new int[n];
        //初始化颜色都为-1,一种颜色为0一种颜色为1
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == -1 && !validColor(0, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validColor(int color, int node) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : nodes[node]) {
            if (!validColor(1-color, next)) {
                return false;
            }
        }
        return true;
    }
    /*
    BFS Solution:
     */
    public boolean BFSisBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3 },
                { 0, 2 },
                { 1, 3, 4 },
                { 0, 2 },
                { 2, 5 },
                { 4 }
        };
        System.out.println(isBipartite(matrix));
    }
}
