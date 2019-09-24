package 数组;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 11:44
 **/

//leetcode260一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
public class 只出现一次的数字III {
    //从头到尾异或所有的数字，这样得到的结果实际上就是两个只出现了一次的数字异或的结果，
    // 我们在异或后的结果中找出其二进制中最右边为1的位，该位既然为1，
    // 说明异或的两个数字对应的该位肯定不同，必定一个为1，一个为0，
    // 因此我们可以考虑根据此位是否为1来划分这两个子数组，这样两个只出现一次的数字就分开了

    //两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
    //
    //diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
    public static void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int[] num1 = {0};
        int[] num2 = {0};
        FindNumsAppearOnce(nums, num1, num2);
    }

}
