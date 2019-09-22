package 数组;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-22 18:36
 **/

/**
 * @Author: zpc
 * @Description: leetcode41. 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * @Create: 2019-09-22 18:36
 **/


public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] >= 1 && A[i] <= A.length && A[A[i]-1] != A[i]) {
                swap(A, i, A[i]-1);
            }else{
                i++;
            }
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
