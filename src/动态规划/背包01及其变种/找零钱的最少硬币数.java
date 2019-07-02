package 动态规划.背包01及其变种;

public class 找零钱的最少硬币数 {
    //完全背包问题
    public int coinChange(int[] coins, int amount) {
        int []dp=new int [amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            dp[i]=Integer.MAX_VALUE;
            //判断是否能由零钱构成
            boolean flag=false;
            for(int coin:coins)
            {

                if(i-coin>=0&&dp[i-coin]!=-1)
                {
                    flag=true;
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
            if(flag==false)
                dp[i]=-1;
        }
        return dp[amount];
    }
}
