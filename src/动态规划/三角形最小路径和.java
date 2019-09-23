package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 17:45
 **/

import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode120. 三角形最小路径和
 * @Create: 2019-09-23 17:45
 **/


public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
