package AAA真题系列AAA.腾讯;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 22:11
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-20 22:11
 **/


public class 腾讯不过4 {
    //输出序列中的最小非零数
    //数组减去x
    private static void minNum(long[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int cur = 0;
        while (k > 0) {
            if (nums[cur] - sum > 0) {
                System.out.println(nums[cur] - sum);
            } else if (nums[cur] - sum < 0) {
                nums[cur] = 0;
                cur++;
                while (nums[cur] - sum < 0 && cur < nums.length) {
                    cur++;
                }
                if (cur == nums.length) {
                    System.out.println(0);
                } else {
                    System.out.println(nums[cur] - sum);
                    sum += nums[cur] - sum;
                }
            } else {
                System.out.println(nums[cur] - sum);
            }
            k--;
        }
    }
}
