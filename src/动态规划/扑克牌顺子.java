package 动态规划;

import java.util.Arrays;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 13:10
 **/

//五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
public class 扑克牌顺子 {
    public boolean isContinuous(int[] nums) {

        if (nums.length < 5)
            return false;

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums)
            if (num == 0)
                cnt++;

        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }

    //max 记录 最大值
    //min 记录  最小值
    //min ,max 都不记0
    //满足条件 1 max - min <5
    //               2 除0外没有重复的数字(牌)
    //               3 数组长度 为5

    public boolean isTrue(int [] numbers) {
        int[]d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            } if(numbers[i] <min){
                min = numbers[i];
            }
        }
        if(max -min<5){
            return true;
        }
        return false;
    }
}
