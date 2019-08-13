package 排序.经典排序;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-13 22:23
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: 希尔排序 平均O（n^1.3）最坏O（n^2）最好O（n）不稳定
 * @Create: 2019-08-13 22:23
 **/

//先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
//
//选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
//按增量序列个数k，对序列进行k 趟排序；
//每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
public class 希尔排序 {
    public static void shellSort(int[] nums) {
        // 计算出最大的h值
        int h = 1;
        while (h <= nums.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < nums.length; i += h) {
                if (nums[i] < nums[i - h]) {
                    int tmp = nums[i];
                    int j = i - h;
                    while (j >= 0 && nums[j] > tmp) {
                        nums[j + h] = nums[j];
                        j -= h;
                    }
                    nums[j + h] = tmp;
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 2, 7, 1, 9};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
