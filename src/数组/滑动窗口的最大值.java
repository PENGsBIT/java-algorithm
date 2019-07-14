package 数组;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 13:03
 **/

//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
//
//例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
public class 滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public static void main(String[] args) {
        maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1},3);

    }
}
