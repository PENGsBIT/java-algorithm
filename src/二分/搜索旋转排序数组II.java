package 二分;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-19 21:25
 **/

/**
 * @Author: zpc
 * @Description: leetcode81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * @Create: 2019-09-19 21:25
 **/


public class 搜索旋转排序数组II {
    public static boolean search(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else {
                //use end-- but left++ works too
                // have no idea about the array,
                // but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 7, 0, 0, 1, 2};
        System.out.println(search(nums,0));
    }
}
