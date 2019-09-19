package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-19 18:21
 **/

/**
 * @Author: zpc
 * @Description: leetcode33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @Create: 2019-09-19 18:21
 **/


public class unity搜索旋转排序数组 {
    public static int search(int A[],  int target) {
        int n = A.length;
        int low=0,hi=n-1;
        // 找到旋转的下标 rotation_index ，也就是数组中最小的元素。二分查找在这里可以派上用场。
        //在选中的数组区域中再次使用二分查找。
        while(low<hi){
            int mid=(low+hi)/2;
            if(A[mid]>A[hi]) low=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=low;
        low=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(low<=hi){
            int mid=(low+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)low=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
    //one search
    public static int onesearch(int[] nums, int target) {
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
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(search(nums,2));
        nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(search(nums,4));
    }
}
