package 数学;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-20 20:09
 **/

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: zpc
 * @Description: 如何随机从n个对象中选择一个对象，这n个对象是按序排列的，但是在此之前你是不知道n的值的。
 * 如果我们知道n的值，那么问题就可以简单的用一个大随机数rand()%n得到一个确切的随机位置，
 * 那么该位置的对象就是所求的对象，选中的概率是1/n。
 *
 * 但现在我们并不知道n的值，这个问题便抽象为蓄水池抽样问题，即从一个包含n个对象的列表S中随机选取k个对象，
 * n为一个非常大或者不知道的值。通常情况下，n是一个非常大的值，
 * 大到无法一次性把所有列表S中的对象都放到内存中。
 *
 * 解法：我们总是选择第一个对象，以1/2的概率选择第二个，以1/3的概率选择第三个，以此类推，
 * 以1/m的概率选择第m个对象。当该过程结束时，每一个对象具有相同的选中概率，即1/n，证明如下。

 * @Create: 2019-08-20 20:09
 **/


public class 蓄水池抽样n个选k {
    //先选中第1到k个元素，作为被选中的元素。然后依次对第k+1至第N个元素做如下操作：
    //每个元素都有k/x的概率被选中，然后等概率的（1/k）替换掉被选中的元素。其中x是元素的序号。
    //在n不同的数中取m个数
    public static int[] Reservoir_Sampling(int[] data, int k) {
        if (data == null||data.length < k) {
            return new int[0];//In <Effective Java>,it advises to return int[0] instead of null.
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

    public static void main(String[] args) {
        int[] data = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(Arrays.toString( Reservoir_Sampling(data, 3)));

    }
}
