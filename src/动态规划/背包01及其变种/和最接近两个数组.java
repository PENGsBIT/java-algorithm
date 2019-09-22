package 动态规划.背包01及其变种;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-22 18:19
 **/

/**
 * @Author: zpc
 * @Description:
 * 将数组分为两部分，使得这两部分和最接近，返回这两部分的差值
 * 【问题】将数组分为两部分，使得两部分的和最接近，返回两部分的差值。例如：
 *
 * int[] array={1,0,1,7,2,4}，分为两部分为{1,0,1,2,4}，{7}，差值为1。
 * @Create: 2019-09-22 18:19
 **/


public class 和最接近两个数组 {
    //动态规划的解法。求得array的和sum，问题转化为：在array中选取若干个元素，使得这些元素的和<=sum/2，
    // 且是最接近sum/2的元素集合。
    //
    //开一个数组：int[][]f=new int[length+1][sum/2+1]
    //
    //状态方程：f[i][j]=Max(f[i-1][j-array[i]]+array[i],f[i-1][j])
    //解释：f[i][j]表示array中i个元素的和<=j，且是最接近j的元素集合。
    // f[i-1][j-array[i]]表示array中i-1个元素的和最接近j-array[i]，
    // 所以f[i][j]应该是[i-1][j-array[i]]+array[i]和f[i-1][j]中最大的那个。有点像0-1背包问题。


    /* f[i][j]表示i个元素装容量为j的背包能装的最大容量 */
    public static int getMaxDiff(int[] array) {
        int sum=0 ;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int length = array.length;
        int[][] f = new int[length + 1][sum / 2 + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                //f[i + 1][j] = f[i][j];
//                if (array[i] <= j && f[i][j - array[i]] + array[i] > f[i][j]) {
//                    f[i + 1][j] = f[i][j - array[i]] + array[i];
//                }
                if (array[i] < j) {
                    f[i + 1][j] = Math.max(f[i][j], f[i][j - array[i]] + array[i]);
                }
            }
        }
        return sum - 2 * f[length][sum / 2];
    }

    public static void main(String[] args) {
        int[] array = { 1, 0, 1, 7, 2, 4 };
        System.out.println(getMaxDiff(array));
    }

}
