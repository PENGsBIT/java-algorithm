package 排序;

import java.util.ArrayList;

public class 合并两个排序数组 {
    /**
     * 合并两个有序数组，双指针法二路归并算法,最后覆盖A数组
     * http://www.lintcode.com/zh-cn/problem/merge-sorted-array/
     * @author yzwall
     */
    class Solution {
        public void mergeSortedArray(int[] A, int m, int[] B, int n) {
            int i = 0, j = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (i < m && j < n) {
                if (A[i] <= B[j]) {
                    list.add(A[i]);
                    i++;
                } else {
                    list.add(B[j]);
                    j++;
                }
            }
            while (i < m) {
                list.add(A[i++]);
            }
            while (j < n) {
                list.add(B[j++]);
            }
            for (int k = 0; k < list.size(); k++) {
                A[k] = list.get(k);
            }
        }
    }
}
