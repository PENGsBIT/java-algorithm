package 排序.经典排序;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-13 21:58
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: 冒泡排序 平均O（n^2）最坏O（n^2）最好O（n）稳定
 * @Create: 2019-08-13 21:58
 **/

//比较相邻的元素。如果第一个比第二个大，就交换它们两个；
//对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
//针对所有的元素重复以上的步骤，除了最后一个；
//重复步骤1~3，直到排序完成。
public class 冒泡排序 {
    public static void bubbleSort(int[]nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {        // 相邻元素两两对比
                    swap(nums, j+1, j);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j+1];        // 元素交换
        nums[j+1] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 2, 7, 1, 9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
