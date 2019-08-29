package 并查集;

//leetcode547. 朋友圈
//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
//
//给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
//
//示例 1:
//
//输入:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
//示例 2:
//
//输入:
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
//

public class 朋友圈 {
    static private int[] root;
    //并查集
    public static int findCircleNum(int[][] M) {
        int m = M.length, cnt = 0;
        root = new int[m];
        //初始化并查集
        for (int i = 0; i < m; i++) root[i] = i;
        //合并
        for (int i = 0; i < m; i++)
            for (int j = i + 1; j < m; j++)
                if (M[i][j] == 1) {
                    union(i, j);
                }

        for (int i = 0; i < m; i++){
            if (i == root[i]) cnt++;
        }

        return cnt;
    }

    private static void union(int v1, int v2) {
        int v1Root = find(v1);//find v1's root
        int v2qRoot = find(v2); //find v2's root
        if (root[v1] != root[v2]) {
            root[v1] = v2; //unite the 2 subtrees
        }
    }
    public static int find(int cur){
        while(cur != root[cur]){
            //在查找的过程中压缩路径,减少查找的次数
            root[cur] = root[root[cur]];
            cur = root[cur];
        }

        return cur;
    }
    public static void main(String[] args) {
        int[][] M={
            {1,1,0},
            {1,1,0},
            {0,0,1},
        };
        System.out.println(findCircleNum(M));
    }

    //dfs
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int dfsFindCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
