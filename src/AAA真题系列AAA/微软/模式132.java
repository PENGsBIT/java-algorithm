package AAA真题系列AAA.微软;

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

    //Optimized 2 O(n) solution
    public static boolean find132patternOp(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        //仍然在每个索引处j，我们需要知道子数组的最小元素nums[0, j)。这可以通过在向前方向上进行预扫描
        // 并在辅助数组中存储每个索引的结果来完成（我们称该数组为，arr其元素arr[j]表示子数组中的最小元素nums[0, j)）。
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

    //One-pass O(n) solution
    public static boolean find132pattern(int[] nums) {
        //利用单调栈做
        int n = nums.length, top = n, third = Integer.MIN_VALUE;
        //维护一个栈和一个变量 third，其中 third 就是第三个数字，
        // 也是 pattern 132 中的2，初始化为整型最小值，
        // 栈里面按顺序放所有大于 third 的数字，也是 pattern 132 中的3，
        //如果当前数字小于 third，即 pattern 132 中的1找到了，我们直接返回 true 即可，因为已经找到了3,2.注意我们应该从后往前遍历数组。
        // 如果当前数字大于栈顶元素，那么我们将栈顶数字取出，赋值给 third，然后将该数字压入栈，
        // 这样保证了栈里的元素仍然都是大于 third 的
        //其中的任何一个值都是大于当前的 third 值，如果有更大的值进来，那就等于形成了一个更优的 second > third 的这样一个组合，并且这时弹出的 third 值比以前的 third 值更大，
        // 为什么要保证 third 值更大，因为这样才可以更容易的满足当前的值 first 比 third 值小这个条件
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top]){
                third = nums[top++];
            }
            nums[--top] = nums[i];
        }

        return false;
    }
    boolean find132patternStack(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> st=new Stack<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < third) return true;
            while (!st.empty() && nums[i] > st.peek()) {
                third = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,3,1};
        System.out.println(find132patternO3(nums));
        System.out.println(find132patternOp(nums));
        System.out.println(find132pattern(nums));
    }
}
