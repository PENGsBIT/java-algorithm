package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-07 23:07
 **/

public class 所有子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));;
    }
    //对于子集来说，每个元素只有2种状态：在子集中，不在子集中
    //这刚好符合2进制，可以考虑使用bitmap的方法。
    //我们对每个元素一个bit：
    //0：在当前子集中
    //1：不在当前子集中
    //对于n个元素，一共有2^n种取法，这和子集数也是一致的。
    //拿2个元素{1,2}举例：
    //00 ——> [] //1不取，2不取
    //01 ——> [1] //取1
    //10 ——> [2] //取2
    //11 ——> [1,2] //取1，2
    //刚好可以取尽所有元素。
    //这个算法的复杂度是O(N^2)，一层循环从0到2^n种取法，二层循环看每个取法对应的2进制中的1的个数
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> mylist = new ArrayList<>();
        //左移一位使得bitmap包含所有的位
        int len = 1 << nums.length;
        //System.out.println(len);
        for (int i = 0; i < len; i++) {
            List<Integer> tmplist = new ArrayList<Integer>();
            int k=i;
            int index = 0;
            while (k > 0) {
                if ((k & 1) > 0) {
                    tmplist.add(nums[index]);
                }
                k=k >> 1;
                index++;
            }
            mylist.add(tmplist);
        }
        return mylist;
    }

}
