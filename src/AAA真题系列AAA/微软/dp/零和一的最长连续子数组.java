package AAA真题系列AAA.微软.dp;

import java.util.HashMap;
import java.util.Map;

// 0 和 1 的最长连续子数组 将原数组的0全部变为-1 则问题等价于“元素值总和为0的连续数组”
// 接着遍历数组 记录当前的前缀和的值 若该前缀和的值已出现过 则说明标记中的下标到当前扫描的下标的这段数组的总和值是为0的
public class 零和一的最长连续子数组 {
    public static void main(String[] args) {
        int[] nums={0,0,0,1};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
}
