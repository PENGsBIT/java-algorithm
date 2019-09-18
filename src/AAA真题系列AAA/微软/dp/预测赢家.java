package AAA真题系列AAA.微软.dp;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-06 21:49
 **/

/**
 * @Author: zpc
 * @Description: leetcode486. 预测赢家
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * <p>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 5, 2]
 * 输出: False
 * 解释: 一开始，玩家1可以从1和2中进行选择。
 * 如果他选择2（或者1），那么玩家2可以从1（或者2）和5中进行选择。如果玩家2选择了5，那么玩家1则只剩下1（或者2）可选。
 * 所以，玩家1的最终分数为 1 + 2 = 3，而玩家2为 5。
 * 因此，玩家1永远不会成为赢家，返回 False。
 * 示例 2:
 * <p>
 * 输入: [1, 5, 233, 7]
 * 输出: True
 * 解释: 玩家1一开始选择1。然后玩家2必须从5和7中进行选择。无论玩家2选择了哪个，玩家1都可以选择233。
 * 最终，玩家1（234分）比玩家2（12分）获得更多的分数，所以返回 True，表示玩家1可以成为赢家。
 * @Create: 2019-09-06 21:49
 **/


public class 预测赢家 {
    //DP
    //dp[i][j]表示从nums[i]到nums[j]先手比另一位玩家多的最大分数，最后返回dp[0][nums.length-1]是否大于0即可
    //对于dp[i][j]，如果先手拿了nums[i]，则另一位玩家比先手多dp[i+1][j]，dp[i][j] = nums[i]-dp[i+1][j]，
    //如果先手拿了nums[j]，则另一位玩家比先手多dp[i][j-1]，dp[i][j] = nums[j]-dp[i][j-1]
    //综上，dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1])
    //当i=j时，先手一定赢，比另一位玩家多dp[i][j]=nums[i]
    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        //对于a0,a1,a2,a3这种偶数，先手必拿a0+a2或者a1,a3，这两个必然一个大一个小，则这种情况下先手必胜
        if (n % 2 == 0 || n == 1) {
            return true;
        }
        int[][] dp = new int[n][n];
        //只有单独元素的时候,因为我们可以很容易地认识到我们可以从dp [i] [i]开始，其中dp [i] [i] = nums [i]。
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = nums[i];
//        }
        //两个及以上的元素
        for (int len = 0; len < n; len++) {
            //从i起头
            for (int i = 0; i < n - len; i++) {
                //j标志末尾index
                int j = i + len;
                if (i == j) {
                    dp[i][i] = nums[i];
                } else {
                    //dp[i][j]表示从nums[i]到nums[j]先手比另一位玩家多的最大分数
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }
//使用5 x 5 dp表作为示例，其中i是行号，j是列号。每个dp [i] [j]对应于表格中第i行，第j列的块。
// 我们可以从填充dp [i] [i]开始，它们都是对角块。我将它们标记为1.
// 然后我们可以看到每个dp [i] [j]仅取决于dp [i + 1] [j]和dp [i] [j - 1]。
// 在表上，它表示每个块（i，j）仅取决于其左侧的块（i，j - 1）及其向下（i + 1，j）。
// 因此，在填充标记为1的所有块之后，我们可以开始计算标记为2的块。之后，所有块都标记为3，依此类推。



    //DP O(n)空间
    public static boolean improvementPredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        //if (n % 2 == 0 || n == 1)
        if ((n & 1) == 0 || n == 1) {
            return true;
        }
        int[] dp = new int[n];
        //从右下角填起
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    //填对角线
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        System.out.println(PredictTheWinner(nums));
        nums= new int[]{1, 5, 233, 7};
        System.out.println(PredictTheWinner(nums));
    }
}
