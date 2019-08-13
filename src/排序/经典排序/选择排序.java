package 排序.经典排序;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-13 22:05
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: 选择排序 平均O（n^2）最坏O（n^2）最好O（n^2）不稳定
 * @Create: 2019-08-13 22:05
 **/

//n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
//
//初始状态：无序区为R[1..n]，有序区为空；
//第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
//n-1趟结束，数组有序化了。
public class 选择排序 {
    public static void selectionSort(int[]nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len-1; j++) {
                if (nums[j] < nums[i]) {     // 寻找最小的数
                    swap(nums,i,j);                // 将最小数的索引保存
                }
            }
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];        // 元素交换
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 2, 7, 1, 9};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
