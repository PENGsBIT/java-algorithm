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
        int cur;
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
        //
//        for (int i=0; i<len; ++i){
//            cur = prices[i];
//            for(int j=k; j>0; --j){
//                sell[j] = Math.max(sell[j],buy[j] + cur);
//                buy[j] = Math.max(buy[j],sell[j-1] - cur);
//            }
//        }
//        return sell[k];
    }

    public static void main(String[] args) {
        System.out.println(kmax(new int[]{3,2,6,5,0,3},2));
    }
}
