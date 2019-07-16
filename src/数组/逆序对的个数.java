package 数组;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-15 20:21
 **/

public class 逆序对的个数 {
//    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007。
    private int cnt;

    public int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return cnt;
    }

    /*
     * 归并排序(从上往下)
     */
    private void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);

        merge(a, start,mid, end);
    }

    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     */
    private void merge(int[] a, int start, int mid,int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, index = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[index++] = a[i++];
            else {
                // 形成逆序a[i] >a[j] a[i+1]到a[mid]>a[i]，所以之后都是逆序对 长度为mid-i+1
                tmp[index++] = a[j++];
                cnt += mid - i + 1;
            }
        }
        while (i <= mid)
            tmp[index++] = a[i++];
        while (j <= end)
            tmp[index++] = a[j++];
//        for (index = 0; index < tmp.length; index++)
//            a[start + index] = tmp[index];
        for (int t : tmp) {
            a[start++]=t;
        }
    }

    public static void main(String[] args) {
        逆序对的个数 t=new 逆序对的个数();
        System.out.println(t.InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
