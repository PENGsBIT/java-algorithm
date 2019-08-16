package 排序;

import java.util.Arrays;

public class 快排 {
    public static void main(String[] args)  {
        int n=5134;
        int [] array={1,-2,3,10,-14,-1,16,3};
        //qsort(array,0,array.length-1);
        qsort2(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void qsort(int arr[],int l,int r){
        if(l >= r) return;
        //p为快速排序返回的基准的位置
        int p = partition(arr,l,r);
        //对基准左边的数进行快排
        qsort(arr,l,p-1);
        //对基准右边的数进行快排
        qsort(arr,p+1,r);
    }
    public static int partition(int arr[],int l,int r){
        //基准元素设为第一个
        int v = arr[l];
        //i指向基准的下一个元素，j指向最后一个元素
        int i = l+1,j = r;
        while(true){
            while(i <= r && arr[i] < v) i++;
            while(j > l && arr[j] > v) j--;
            //循环终止条件
            if(i > j) break;
            //交换arr[i]与arr[j]
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        //将基准元素与arr[j]交换
//        int t = arr[l];
        arr[l] = arr[j];
//        arr[j] = t;
        arr[j] = v;
        //返回基准元素所在位置
        return j;
    }

    public static void qsort2(int arr[],int l,int r){
        if(l >= r) return;
        //p为快速排序返回的基准的位置
        int p = partition2(arr,l,r);
        //对基准左边的数进行快排
        qsort2(arr,l,p-1);
        //对基准右边的数进行快排
        qsort2(arr,p+1,r);
    }
    private static int partition2(int[] a, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int temp = a[l];
            while (i < j) {
                while (i < j && a[j] >= temp) {
                    j--;
                }
                a[i] = a[j];
                while (i < j && a[i] <= temp) {
                    i++;
                }
                a[j] = a[i];
            }
            a[i] = temp;
            return i;
        }
       else return -1;
    }

}
