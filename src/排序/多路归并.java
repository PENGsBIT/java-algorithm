package 排序;

import java.util.*;

public class 多路归并 {
    /**
     * 解法1：逐个合并数组，时间复杂度O(n*k)，n >> k
     * 合并k个排序（升序）数组
     * http://www.lintcode.com/zh-cn/problem/merge-k-sorted-arrays/
     * @author yzwall
     */
    class Solution {
        public List<Integer> mergekSortedArrays(int[][] arrays) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
                return list;
            }
            if (arrays.length == 1) {
                Arrays.sort(arrays[0]);
                for (int num : arrays[0]) {
                    list.add(num);
                }
                return list;
            }

            int[] temp = mergeTwoArrays(arrays[0], arrays[1]);
            for (int i = 2; i < arrays.length; i++) {
                temp = mergeTwoArrays(temp, arrays[i]);
            }
            for (int num : temp) {
                list.add(num);
            }
            return list;
        }

        private int[] mergeTwoArrays(int[] A, int[] B) {
            if (A.length == 0 || B.length == 0) {
                return new int[0];
            }
            int[] temp = new int[A.length + B.length];
            int index = 0, i = 0, j = 0;
            while (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    temp[index++] = A[i++];
                } else {
                    temp[index++] = B[j++];
                }
            }
            while (i < A.length) {
                temp[index++] = A[i++];
            }
            while (j < B.length) {
                temp[index++] = B[j++];
            }
            return temp;
        }
    }

    /**
     * 解法2：分治法K路归并，时间复杂度O(n logk)
     * 合并k个排序（升序）数组
     * http://www.lintcode.com/zh-cn/problem/merge-k-sorted-arrays/
     * @author yzwall
     */
    class Solution20 {
        public List<Integer> mergekSortedArrays(int[][] arrays) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
                return list;
            }
            int[] ans = kMergeSort(arrays, 0, arrays.length - 1);
            for (int num : ans) {
                list.add(num);
            }
            return list;
        }

        // 分治递归深度为O(log k), 每层合并时间复杂度O(n)
        private int[] kMergeSort(int[][] arrays, int start, int end) {
            if (start >= end) {
                return arrays[start];
            }
            int mid = start + (end - start) / 2;
            int[] left = kMergeSort(arrays, start, mid);
            int[] right = kMergeSort(arrays, mid + 1, end);
            return mergeTwoArrays(left, right);
        }

        private int[] mergeTwoArrays(int[] A, int[] B) {
            int[] temp = new int[A.length + B.length];
            int index = 0, i = 0, j = 0;
            while (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    temp[index++] = A[i++];
                } else {
                    temp[index++] = B[j++];
                }
            }
            while (i < A.length) {
                temp[index++] = A[i++];
            }
            while (j < B.length) {
                temp[index++] = B[j++];
            }
            return temp;
        }
    }

    /**
     * 解法3：最小堆实现K路归并，时间复杂度O(n logk)
     * 合并k个排序（升序）数组
     * http://www.lintcode.com/zh-cn/problem/merge-k-sorted-arrays/
     * @author yzwall
     */
    class Solution18 {
        private class NewInteger {
            int value, row, col;
            public NewInteger(int value, int row, int col) {
                this.value = value;
                this.row = row;
                this.col = col;
            }
        }

        public List<Integer> mergekSortedArrays(int[][] arrays) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
                return list;
            }
            PriorityQueue<NewInteger> pq = new PriorityQueue<>(arrays.length, new Comparator<NewInteger>() {
                public int compare(NewInteger o1, NewInteger o2) {
                    return o1.value < o2.value ? -1 : 1;
                }
            });

            for (int i = 0; i < arrays.length; i++) {
                pq.offer(new NewInteger(arrays[i][0], i, 0));
            }
            while (!pq.isEmpty()) {
                NewInteger min = pq.poll();
                if (min.col + 1 < arrays[min.row].length) {
                    pq.offer(new NewInteger(arrays[min.row][min.col + 1], min.row, min.col + 1));
                }
                list.add(min.value);
            }

            return list;
        }
    }

    /**
     * 解法4：暴力方法，将所有数组添加到List，统一排序，时间复杂度O(n*k + nlogn), n >> k
     * 合并k个排序（升序）数组
     * http://www.lintcode.com/zh-cn/problem/merge-k-sorted-arrays/
     * @author yzwall
     */
    class Solution19 {
        public List<Integer> mergekSortedArrays(int[][] arrays) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
                return list;
            }
            for (int i = 0; i < arrays.length; i++) {
                addToList(list, arrays[i]);
            }
            Collections.sort(list);
            return list;
        }

        private void addToList(ArrayList<Integer>list, int[] nums) {
            for (int num : nums) {
                list.add(num);
            }
        }
    }
}
