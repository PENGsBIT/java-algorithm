package 动态规划;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-08 20:37
 **/

public class 不同的二叉搜索树 {
    //给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
    public static int numTrees(int n) {
        //dp [k]表示从1 .... k建立的BST树的数量;
        //枚举序列中的每个数字i，并使用数字作为根，自然地，子序列1 ...（i-1）在它的左侧将放置在根的左侧分支上，
        // 同样右侧子序列（i + 1）... n位于根的右侧分支上。
        int [] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                //左树的个数乘以右数的个数
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(7));

    }
}
