package 动态规划.背包01及其变种;

public class 找零钱的硬币数组合 {
    public static void main(String[] args) {
        System.out.println(change(new int[]{1,2,5},5));
    }
    public static int change(int []coins,int total){
        int []dp=new int[total+1];
        dp[0]=1;
        for (int coin : coins) {
            for (int i = coin; i <=total; i++) {
                dp[i]+=dp[i-coin];
            }
        }
        return dp[total];
    }
}
