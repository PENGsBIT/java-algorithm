package 动态规划.股票;

public class 冷却期股票 {
    public static void main(String[] args) {
        System.out.println(coldMax1(new int[]{1, 2, 3, 0, 2}));
    }


    public static int coldMax1(int[] prices) {
        int len=prices.length;
        int[]buy=new int[len];
        int[]cold=new int[len];
        int[]sell=new int[len];
        buy[0]=-prices[0];
        //如果我们index:i天为冷冻期，那么只能说明index:i-1天卖掉了股票，那么i天的收益和i-1天是一样的
        //cooldown[i]=sell[i-1]
        //如果我们考虑index:i天卖出，要求利润最大的话。一种情况是index:i-1当天买入了股票，
        // 另一种情况是index:i-1之前就持有股票，index:i-1天也可以卖出，
        // 那么我们就需要考虑index:i-1卖出更好呢？还是index:i卖出更好呢？
        //一种情况是index:i-1天是冷冻期，另一种情况是index:i-1天不是冷冻期，也就是index:i-1天也可以买入，
        // 那么我们就需要考虑index:i-1买入更好呢？还是index:i买入更好呢？
        for (int i = 1; i <len ; i++) {
            cold[i]=sell[i-1];
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],cold[i-1]-prices[i]);
        }
        return Math.max(sell[len - 1], cold[len - 1]);
    }



}
