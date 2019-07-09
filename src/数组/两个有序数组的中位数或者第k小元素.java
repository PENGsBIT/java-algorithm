package 数组;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-09 23:11
 **/

public class 两个有序数组的中位数或者第k小元素 {
    //两个排序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //让我们在任一位置  将 A 划分成两个部分,采用同样的方式，我们在任一位置 [公式] 将 B 划分成两个部分：
//        将 left_A 和 left_B 放入一个集合，并将 right_A 和 right_B 放入另一个集合。 再把这两个新的集合分别命名为 left_part 和 right_part：
//        我们已经将 {A,B} 中的所有元素划分为相同长度的两个部分，且其中一部分中的元素总是大于另一部分中的元素。
//        1、len(left_part)==len(right_part)2、max(left_part)<=max(right_part)
// 那么：median==(max(left)+min(right))/2
        int n1Length = nums1.length;
        int n2Length = nums2.length;
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        // nums1 should be smaller array.
        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int mid1 = (left+right)/2;
            int mid2 = (n1Length + n2Length + 1)/2 - mid1 ;

            int n1Left = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int n1Right = mid1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1];

            int n2Left = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int n2Right = mid2 == nums2.length ? Integer.MAX_VALUE : nums2[mid2];

            // Now compare.
            if(n1Left <= n2Right && n2Left <= n1Right) {
                if((n1Length+n2Length) % 2 == 0) {
                    return (Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2.0;
                }

                return Math.max(n1Left, n2Left);
            }
            else if(n1Left > n2Right) right = mid1 - 1;
            else left = mid1 + 1;
        }
        return -1.0;
    }
}
