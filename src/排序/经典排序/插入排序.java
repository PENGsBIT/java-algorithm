package 排序.经典排序;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-13 22:16
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: 插入排序 平均O（n^2）最坏O（n^2）最好O（n）稳定
 * @Create: 2019-08-13 22:16
 **/

//从第一个元素开始，该元素可以认为已经被排序；
//取出下一个元素，在已经排序的元素序列中从后向前扫描；
//如果该元素（已排序）大于新元素，将该元素移到下一位置；
//重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
//将新元素插入到该位置后；
//重复步骤2~5。
public class 插入排序 {
    public static void insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int currentNumber = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > currentNumber) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = currentNumber;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 2, 7, 1, 9};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
