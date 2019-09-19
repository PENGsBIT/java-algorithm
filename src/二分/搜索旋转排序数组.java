package 二分;

import java.util.Arrays;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-04 22:30
 **/
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//你可以假设数组中不存在重复的元素。
//你的算法时间复杂度必须是 O(log n) 级别。

public class 搜索旋转排序数组 {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
    private static int searchRotated(int[] nums, int target) {
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]>=nums[i+1]){
                int res= Arrays.binarySearch(nums,0,i,target);
                res=res==-1?Arrays.binarySearch(nums,i+1,nums.length-1,target):res;
                return res;
            }
        }
        return -1;
    }
    //Arrays.binarySearch
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 1;
        System.out.println(searchRotated(nums, target));
        System.out.println(search(nums,target));
    }
}
