package AAA真题系列AAA.微软.图;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-06-24 22:21
 **/

public class m着色问题 {
    private static int n = 5;//图的顶点数
    private static int m = 4;//可用颜色数
    private static int count = 0;//着色数
    private static int[] colors = new int[n];//可用颜色数color[n],大小为n,下标肯定代表顶点，里面的值代表这个顶点放的是哪种颜色。

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };
        //图的邻接矩阵
        traceback(0, matrix);
        System.out.println(count);
    }

    //curNode 当前节点
    private static void traceback(int curNode, int[][] matrix) {
        if (curNode >= n) {
            count++;
        } else {
            // 填充颜色
            for (int i = 1; i <= m; i++) {
                colors[curNode] = i;
                if (canColor(curNode, matrix)) {
                    traceback(curNode + 1, matrix);
                }
                colors[curNode] = 0;
            }
        }
    }

    private static Boolean canColor(int cur, int[][] matrix) {
        for (int j = 0; j < n; j++) {
            //判断当前位置的颜色是否和相邻位置颜色重复
            if (matrix[cur][j] == 1 && colors[cur] == colors[j])
                return false;

        }
        return true;
    }


}
