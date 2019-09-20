package AAA真题系列AAA.微软;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 10:02
 **/

public class 数组中出现次数超过一半的数字 {
    //多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
    //使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。
    // 如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，
    // 但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
    // 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
    public static Integer MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        //验证没有major 的情况
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : null;

    }

    //虚拟栈思想
    public static int MoreThanHalfNum(int[] array) {
        //栈顶和栈内元素
        int top = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (top != array[i] && count == 0) {
                top = array[i];
            } else if (top == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return top;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 1};
        System.out.println(MoreThanHalfNum_Solution(nums));
        System.out.println(MoreThanHalfNum(nums));
        int[] nums1 = new int[]{2, 2, 3, 1, 1};
        System.out.println(MoreThanHalfNum_Solution(nums1));
        System.out.println(MoreThanHalfNum(nums1));
    }
}
