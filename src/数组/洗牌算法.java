package 数组;

import java.util.Random;

public class 洗牌算法 {

    public static void main(String[] args) {
        int[] data = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        print(data);
        shuffleSort(data);
        System.out.println("排序后的数组：");
        print(data);
        System.out.println("蓄水池抽样在o（n）时间内对n个数据进行等概率随机抽取");
        Reservoir_Sampling(data, 3);
        print(data);
    }

    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void shuffleSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int j = (int) (data.length * Math.random());
            swap(data, i, j);
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    //在n不同的数中取m个数
    public static int[] Reservoir_Sampling(int[] data, int k) {
        if (data == null) {
            return new int[0];//In <Effective Java>,it advises to return int[0] instead of null.Am i doing right in this case?
        }
        if (data.length < k) {
            return new int[0];
        }
        int[] sample = new int[k];
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sample[i] = data[i];
            } else {
                int j = new Random().nextInt(i);
                if (j < k) {
                    sample[j] = data[i];
                }
            }
        }
        return sample;
    }
}


