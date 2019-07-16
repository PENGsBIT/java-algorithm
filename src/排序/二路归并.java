package 排序;

import java.util.Arrays;

public class 二路归并 {
    /**
     * 归并排序一个整型数组（升序）
     *
     * @author zpc
     */
    // 分治递归空间O(logn)，逐层合并时间复杂度O(n)
    private static void mergeSort(int[] A, int start, int end) {
        if (A == null || A.length == 0||start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        mergeTwoArrays(A, start, mid, end);
    }

    // 二路归并时间复杂度O(n)，空间复杂度O(n)
    private static void mergeTwoArrays(int[] A, int start, int mid, int end) {
        //int mid = start + (end - start) / 2;
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

        for (int t : temp) {
            A[start++]=t;
        }
//        for (int k = 0; k < index; k++) {
//            A[start + k] = temp[k];
//        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
