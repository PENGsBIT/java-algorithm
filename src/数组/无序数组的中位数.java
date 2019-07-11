package 数组;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-10 22:46
 **/

public class 无序数组的中位数 {
    public static void main(String[] args) {
        int[] a = { 1, -2, 3, 10, -14, -1, 16, 3 };
        int middleByPartition = findMiddleByPartition(a, 0, a.length);
        System.out.println(a[middleByPartition]);
    }

    public static int findMiddleByPartition(int[] array, int left, int right) {
        //一次partition就是找到第k位
        int i = left, j = right;
        int key = array[left];
        while (true) {
            // j向左走，直到找到一个小于key的数
            while (array[++i] > key && i < right) ;
            // i向右走，直到找到一个大于key的数
            while (array[--j] < key && j > left) ;
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, left, i);
        if (i == array.length / 2) {
            return i;
        } else if (i < array.length / 2) {
            return findMiddleByPartition(array, i + 1, right);
        } else {
            return findMiddleByPartition(array, left, i - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
