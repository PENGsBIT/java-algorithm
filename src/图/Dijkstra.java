package 图;

import java.util.Scanner;

/*
输入格式为，第一行n、m分别表示点数量和边数量（单向边），接下去m行表示每条边的起点、终点和边长度。求第1个点到第n个点的最短路径。其中边权均为正数。
例：
5 7
1 2 6
1 3 2
1 4 10
2 4 3
2 5 8
3 4 4
4 5 5

Dijkstra是基于贪心思想的单源最短路径算法，它的思想是在没有负权边的情况下，当前的最小距离点的距离值不会再被更新，它主要步骤分为以下三步：
1、当到一个时间点时，图上部分的点的最短距离已确定，部分点的最短距离未确定。
2、选一个所有未确定点中离源点最近的点，把他认为成最短距离。
3、再把这个点所有出边遍历一边，更新所有的点。

由于算法基于寻找最小距离点来更新其它点，而且每个点的距离是在动态变化中。所以很自然的想到使用堆来优化。根据每个点的距离来维护一个小根堆，
每次取堆顶元素来更新其它点距离，每次更新都去维护堆的有序性。根据贪心的思想，由于取出的点已经是最短距离，所以不需要再加入到堆中。
*/
@SuppressWarnings("Duplicates")
public class Dijkstra {
    /**
     * Edge类用于存储边的终点和权值。
     * 因为使用到邻接链表，所以next表示链表中下一条边所在位置。
     */
    static class Edge {
        int y, z, next;

        Edge(int y, int z) {
            this.y = y;
            this.z = z;
        }
    }

    private int n, m, heapSize;
    // 邻接链表的索引，head[x]表示以x为起点的第一条边所在位置。
    private int[] head;
    // 所有边的集合
    private Edge[] edges;
    // 维护堆中点与输入点序号的对应关系
    private int[] heap2node;
    // 维护输入点序号与堆中位置的对应关系
    private int[] node2heap;
    // 存储起点到每个点的最短距离
    private int[] dist;

    /**
     * 在p位置向上调整堆，用于某个点的距离更新后（一定是变小），维护小根堆的有序性
     *
     * @param p 堆中的位置
     */
    private void up(int p) {
        while ((p >> 1) >= 1) {
            int q = p >> 1;
            if (dist[heap2node[q]] > dist[heap2node[p]]) {
                node2heap[heap2node[p]] = q;
                node2heap[heap2node[q]] = p;
                int t;
                t = heap2node[p]; heap2node[p] = heap2node[q]; heap2node[q] = t;
            } else {
                break;
            }
        }
    }

    /**
     * 在p位置向下调整堆，用于取出堆顶元素后，将堆尾元素填充至堆顶后，从堆顶开始维护小根堆的有序性
     *
     * @param p 堆中的位置
     */
    private void down(int p) {
        while ((p << 1) <= heapSize) {
            int q = p << 1;
            if (q < heapSize && dist[heap2node[q + 1]] < dist[heap2node[q]]) {
                q++;
            }
            if (dist[heap2node[p]] > dist[heap2node[q]]) {
                node2heap[heap2node[p]] = q;
                node2heap[heap2node[q]] = p;
                int t;
                t = heap2node[p]; heap2node[p] = heap2node[q]; heap2node[q] = t;
            } else {
                break;
            }
        }
    }

    /**
     * 弹出堆顶元素对应的点序号，堆顶元素即当前最小距离点
     *
     * @return 点序号
     */
    private int pop() {
        if (heapSize < 1) {
            return -1;
        }
        int node = heap2node[1];
        heap2node[1] = heap2node[heapSize];
        node2heap[heap2node[heapSize]] = 1;
        heapSize--;
        down(1);
        return node;
    }

    private Dijkstra() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        head = new int[n + 1];
        heap2node = new int[n + 1];
        node2heap = new int[n + 1];
        dist = new int[n + 1];
        edges = new Edge[m];
        heapSize = n;
        for (int i = 1; i <= n; i++) {
            head[i] = -1;
            heap2node[i] = i;
            node2heap[i] = i;
            dist[i] = 1000000007;
        }
        for (int i = 0; i < m; i++) {
            int x, y, z;
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            edges[i] = new Edge(y, z);
            edges[i].next = head[x];
            head[x] = i;
        }
        dist[1] = 0;
        while (true) {
            // 每次弹出最小距离点
            int node = pop();
            // 到达终点或堆已为空（不连通的图）即退出循环
            if (node == n || node == -1) {
                break;
            }
            // 对最小距离点相连的所有边做遍历，试图更新各边终点的最小距离，并持续维护堆。
            for (int i = head[node]; i >= 0; i = edges[i].next) {
                if (dist[node] + edges[i].z < dist[edges[i].y]) {
                    dist[edges[i].y] = dist[node] + edges[i].z;
                    int p = node2heap[edges[i].y];
                    up(p);
                }
            }
        }
        System.out.println(dist[n]);
    }

    public static void main(String[] args) {
        new Dijkstra();
    }
}
