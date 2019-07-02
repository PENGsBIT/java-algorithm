package 动态规划.股票;

import java.util.Arrays;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-06-18 21:34
 **/

public class 买卖两次 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,2,6,5,0,3}));
    }
    public static int maxProfit(int[] prices) {
        int []buy=new int[3];
        int []sell=new int[3];
        Arrays.fill(buy,Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <3 ; i++) {
                buy[i]=Math.max(buy[i],sell[i-1]+price);
                sell[i]=Math.max(sell[i],buy[i]-price);
            }
        }
        return sell[2];
    }
}
