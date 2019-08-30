package 栈;

//456. 132模式
//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
//注意：n 的值小于15000。
//
//示例1:
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//示例 2:
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//示例 3:
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].

import java.util.Arrays;
import java.util.Stack;

public class 模式132 {
    //stack
    //维护一个栈和一个变量 third，其中 third 就是第三个数字，也是 pattern 132 中的2，初始化为整型最小值，栈里面按顺序放所有大于 third 的数字，
    //也是 pattern 132 中的3，那么我们在遍历的时候，如果当前数字小于 third，即 pattern 132 中的1找到了，我们直接返回 true 即可
    public static boolean stfind132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < third) return true;
            //nums[i] > st.peek()找到递减的区间段，使得j>k,a[j]>a[k],也就是找到a[j]和third
            while (!st.empty() && nums[i] > st.peek()) {
                third = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }

    //One-pass O(n) solution
    public static boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third){
                return true;
            }
            while (top < n && nums[i] > nums[top]){
                third = nums[top++];
            }
            nums[--top] = nums[i];
        }

        return false;
    }

    //Optimized O(n^2) to O(n) solution
    public static boolean find132patternOp(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }

        return false;
    }


    //Improved O(n^2) solution
    //固定一个数。我们选择固定a[j]，因为a[j]在次序上处于中间，可以确定另两个数的范围。那这样问题就变为在a[j]的左边找到一个数比它小的数a[i]，右边找到一个比它小的数a[k]，满足a[i]<a[k]。
    // 那么我们可以挑选a[j]左边的最小值和a[j]右边的最大值（前提都需要小于a[j]）作为a[i]和a[k]进行比较。假如这样子都无法满足a[i]<a[k]的条件那显然是无解的。
    public boolean find132patternO2(int[] nums) {
        for (int j = 0, min = Integer.MAX_VALUE; j < nums.length; j++) {
            min = Math.min(nums[j], min);
            if (min == nums[j]) continue;

            for (int k = nums.length - 1; k > j; k--) {
                if (min < nums[k] && nums[k] < nums[j]) return true;
            }
        }

        return false;
    }

    //Naive O(n^3) solution
    public static boolean find132patternO3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums = { 3, 1, 4, 2 };
        int[]nums = {-1, 3, 2, 0 };
        System.out.println(stfind132pattern(nums));
        System.out.println(find132patternOp(nums));
        System.out.println(find132patternO3(nums));
        System.out.println(find132pattern(nums));

    }
}
