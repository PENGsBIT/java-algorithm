package 动态规划.股票;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-23 19:21
 **/

import java.util.Scanner;

/**
 * @Author: zpc
 * @Description: leetcode 714
 * @Create: 2019-08-23 19:21
 **/


public class 买卖股票有手续费 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int F=sca.nextInt();
        int N=sca.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i <N ; i++) {
            prices[i] = sca.nextInt();
        }
        System.out.println(maxSell(prices, F));
    }

    private static int maxSell1(int[] prices, int f) {
        if (prices == null || prices.length <=1 || f < 0) {
            return 0;
        }
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            int temp = buy;
            buy = Math.max(buy, sell - price - f);
            sell = Math.max(sell, temp + price);
        }
        return sell;
    }
    private static int maxSell(int[] prices, int f) {
        if (prices == null || prices.length <=1 || f < 0) {
            return 0;
        }
        int buy[] = new int[prices.length],sell[]=new int[prices.length];
        buy[0] = -prices[0] - f;
        for (int i = 1; i <prices.length ; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - f);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length-1];
    }
}
