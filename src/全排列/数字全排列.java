package 全排列;

import java.util.Arrays;

public class 数字全排列 {

        public static void main(String[] args) {
            int[] arr = { 1, 2, 3, 4 };
            fullSort(arr, 0, arr.length - 1);
        }

        public static void fullSort(int[] arr, int start, int end) {
            // 递归终止条件
            if (start == end) {
                System.out.print(Arrays.toString(arr));
                System.out.println();
                return;
            }
            for (int i = start; i <= end; i++) {
                swap(arr, i, start);
                fullSort(arr, start + 1, end);
                swap(arr, i, start);
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }


}
