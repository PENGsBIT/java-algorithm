package 数组;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 14:01
 **/

/**
 * @Author: zpc
 * @Description:
 * leetcode136只出现一次的数字
 * 提交记录
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @Create: 2019-09-24 14:01
 **/


public class 只出现一次的数字 {
    int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }
}
