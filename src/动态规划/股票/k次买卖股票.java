package 动态规划.股票;

import java.util.Arrays;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-05-30 23:04
 **/

public class k次买卖股票 {
    public static int kmax(int[]prices,int k){
        if (prices==null||prices.length<1)return 0;
        int len=prices.length,res=0;
        if (k>=len/2){
            for (int i = 1; i < len; i++) {
                if (prices[i]>prices[i-1]){
                    res+=prices[i]-prices[i-1];
                }
            }
            return res;
        }
        int []buy=new int[k+1];
        int []sell=new int[k+1];
        Arrays.fill(buy,Integer.MIN_VALUE);

        //通过数组记录每次buy & sell 后的最大值（eg： 第一次买入3元， 其实就是目前收入 -3）。
        //1.第k次buy就是 上一次卖出剩下的钱 - 本次购买需要的钱
        //2.第k次sell就是 第k次买入 + 本次卖出的钱
        for (int price : prices) {
            for (int i = 1; i <=k ; i++) {
                buy[i]=Math.max(buy[i],sell[i-1]-price);
                sell[i]=Math.max(sell[i],buy[i]+price);
            }
        }
        return sell[k];

        //只用大小为k的一维数组记录到达第i天时的局部最优解和全局最优解。需要注意的是，
        // 由于第i天时交易k次的最优解依赖于第i-1天时交易k-1次的最优解，所以数组更新应当从后往前（即从k到1）更新。
//        int[] local = new int[k + 1];
//        int[] global = new int[k + 1];
//
//        for (int i = 1; i < prices.length ; i++) {
//            int diff = prices[i] - prices[i - 1];
//
//            for (int j = k; j > 0; j--) {
//                local[j] = Math.max(global[j - 1], local[j] + diff);
//                global[j] = Math.max(global[j], local[j]);
//            }
//        }

    }

    public static void main(String[] args) {
        System.out.println(kmax(new int[]{3,2,6,5,0,3},2));
    }
}
