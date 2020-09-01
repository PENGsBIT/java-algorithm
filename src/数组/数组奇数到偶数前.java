package 数组;

import java.util.Arrays;

/**
 * @Program: java-algorithm
 * @Author: ZPC
 * @Package: 数组
 * @ClassName: 数组奇数到偶数前
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 要求：时间复杂度O(n)，空间复杂度O(1)。
 * @Create: 2020-09-01 11:02
 **/
public class 数组奇数到偶数前 {
    //数组[1,2,3,4,5,6,7,8]
    //从头找到第一个偶数2和末尾第一个奇数7，交换位置为[1,7,3,4,5,6,2,8]
    //开头第二个偶数4和末尾第二个奇数5，交换位置为[1,7,3,5,4,6,2,8]
    public static int[] reOrderArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && isOdd(nums[left])) left++;
            while (left < right && !isOdd(nums[right])) right--;
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static boolean isOdd(int num) {
        //        任何整数 & 1
        //        结果为 1 ，则为奇数
        //        结果为 0 ，则为偶数
        return (num & 1) == 1;
    }


    public static int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 != 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
                ;
            }
        return A;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        reOrderArray(nums);
        //sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }
}
