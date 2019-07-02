package 排序;

public class 二路归并 {
    /**
     * http://www.lintcode.com/en/problem/sort-integers-ii/
     * 归并排序一个整型数组（升序）
     * @author yzwall
     */
    class Solution {
        public void sortIntegers2(int[] A) {
            if (A == null || A.length == 0) {
                return;
            }

            mergeSort(A, 0, A.length - 1);
        }
        // 分治递归空间O(logn)，逐层合并时间复杂度O(n)
        private void mergeSort(int[] A, int start, int end) {
            if (start >= end) {
                return;
            }
            int mid = start + (end - start) / 2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            mergeTwoArrays(A, start, end);
        }

        // 二路归并时间复杂度O(n)，空间复杂度O(n)
        private void mergeTwoArrays(int[] A, int start, int end) {
            int mid = start + (end - start) / 2;
            int i = start, j = mid + 1;
            int index = 0;
            int[] temp = new int[end - start + 1];
            while (i <= mid && j <= end) {
                if (A[i] < A[j]) {
                    temp[index++] = A[i++];
                } else {
                    temp[index++] = A[j++];
                }
            }
            while (i <= mid) {
                temp[index++] = A[i++];
            }
            while (j <= end) {
                temp[index++] = A[j++];
            }

            for (int k = 0; k < index; k++) {
                A[start + k] = temp[k];
            }
        }
    }
}
