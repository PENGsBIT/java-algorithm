package 排序.经典排序;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-13 22:28
 **/

import java.util.Arrays;

/**
 * @Author: zpc
 * @Description: 计数排序 平均O（n+k）最坏O（n+k）最好O（n+k）稳定
 * @Create: 2019-08-13 22:28
 **/

//找出待排序的数组中最大和最小的元素；
//统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
//对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
//反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
public class 计数排序 {

    private static int[] countSort(int[] array, int k) {
        int[] C = new int[k + 1];//构造C数组
        int length = array.length, sum = 0;//获取A数组大小用于构造B数组
        int[] B = new int[length];//构造B数组
        for (int i = 0; i < length; i++) {
            C[array[i]] += 1;// 统计A中各元素个数，存入C数组
        }
        for (int i = 0; i < k + 1; i++)//修改C数组
        {
            sum += C[i];
            C[i] = sum;
        }
        for (int i = length - 1; i >= 0; i--)//遍历A数组，构造B数组
        {

            B[C[array[i]] - 1] = array[i];//将A中该元素放到排序后数组B中指定的位置
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素

        }
        return B;//将排序好的数组返回，完成排序

    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = countSort(A, 5);
        System.out.println(Arrays.toString(B));
    }

}
