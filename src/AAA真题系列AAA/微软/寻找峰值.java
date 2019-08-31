package AAA真题系列AAA.微软;

public class 寻找峰值 {
    public static void main(String[] args) {
        int []a={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(a));
        System.out.println(findVally(a));
    }
    private static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left +( right-left)/2;
            //int mid = (left + right)>>>1;
            if (nums[mid] > nums[mid + 1]) right = mid;
            else left = mid+1;
        }
        return right;
    }
    private static int findVally(int[] nums){
        int l=0,r=nums.length;
        while (l<r){
            int mid=(l+r)>>>1;
            if(nums[mid]>nums[mid+1]){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return r;
    }
}
