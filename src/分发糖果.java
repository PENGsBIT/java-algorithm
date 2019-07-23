/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-23 21:05
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: 分发糖果
 * @Create: 2019-07-23 21:05
 **/

//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
//你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//每个孩子至少分配到 1 个糖果。
//相邻的孩子中，评分高的孩子必须获得更多的糖果。
//那么这样下来，老师至少需要准备多少颗糖果呢？
//
public class 分发糖果 {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }

        for(int i = n - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i]){
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            }
        }

        int sum = 0;
        for(int r: res) sum += r;

        return sum;
    }

    public static void main(String[] args) {
        //5,分发 2、1、2 颗糖果。
        System.out.println(candy(new int[]{1,0,2}));
        //4,1、2、1
        System.out.println(candy(new int[]{1,2,2}));
    }
}
