package 动态规划.股票;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-19 19:45
 **/

/**
 * @Author: zpc
 * @Description: leetcode121买卖一次股票
 * @Create: 2019-08-19 19:45
 **/


public class 股票买卖一次 {
    public static int MaxProfitSellOne(int[]prices) {
        int maxCur = 0, max = 0;
        for (int i = 1; i <prices.length ; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            max = Math.max(max, maxCur);
        }
        return max;
    }
    public static int MaxProfitSellOne1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }
}
