package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-21 23:30
 **/

/**
 * @Author: zpc
 * @Description: 钢条切割
 * @Create: 2019-07-21 23:30
 **/

//长度为 i 英寸的钢条的价格为 pi( i =1,2,3,4…单位问美元)。钢条的长度为整英寸。
//长度i,1,2,3,4,5,6,7,8,9
//价格pi,1,5,8,9,10,17,17,20,24
public class 钢条切割 {
    //最优收益值Ri
    //Rn = max(Pn, R1 + Rn-1, R2 + Rn-2,…,Rn-1 + R1)
    //第一个参数Pn对应不切割，直接出售长度为n的方案。
    //其他n-1个参数对应n-1种方案。对每个i=1,2,….,n-1，将钢条切割为长度为i和n-i的两段，接着求解这两段的最优切割收益Ri和Rn-i;(每种方案的最优收益为两段的最优收益之和)。
    //由于无法预知哪种方案会获得最优收益，必须考察所有可能的 i ，选取其中收益最大者。若不切割时收益最大，当然选择不切割。
    /**
     * 动态规划方法
     *              带备忘的自顶向下法
     * @param p，钢条的价格数组，
     * @param n，钢条的长度，这里的划分是以 1 为单位
     * @return 最大收益
     */
    public static int memoized_cut_rod(int[] p,int n){
        //一个数组，用r[i] 来保存 钢条长度为 i 的时候的最优值，初始值赋为 -1.一个负值就行。
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int[] dp= new int[n+1];
        for (int i=1;i<=n;i++){
            for (int j = 1; j <=i ; j++) {
                dp[i] = Math.max(dp[i], p[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(memoized_cut_rod(new int[]{0,1, 5, 8, 9, 10, 17, 17, 20, 24}, 3));;
    }
}
