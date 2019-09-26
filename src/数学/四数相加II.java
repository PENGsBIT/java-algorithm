package 数学;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-25 14:40
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zpc
 * @Description: leetcode454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @Create: 2019-09-25 14:40
 **/


public class 四数相加II {
    //Time complexity:  O(n^2)
    //Space complexity: O(n^2)
    //将数组C，D 任意组合的和存入查找表中，
    //key是和，value 是出现的次数。记录A，B 任意组合的和的负值，然后在查找表中查找是否有对应的值
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[]A = {1, 2};
        int[]B = {-2,-1};
        int[]C = {-1, 2};
        int[]D = {0, 2};
        System.out.println(fourSumCount(A,B,C,D));
    }

}
