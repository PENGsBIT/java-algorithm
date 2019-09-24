package 数组;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 14:12
 **/

/**
 * @Author: zpc
 * @Description: leetcode137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * @Create: 2019-09-24 14:12
 **/


public class 只出现一次的数字II {
    //其他元素都出现了三次，按位计算每一位上1的个数，结果模3为1的那些位就是所求数二进制1所在的位。
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<32;i++){
            int mask = 1<<i;
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if((mask&nums[j])!=0)
                    count++;
            }
            if(count%3==1)
                result = mask|result;
        }
        return result;
    }
    //通常的位操作代码很难获取和复制。我喜欢考虑32位的数字，只计算每个位中有多少个1，并在sum %= 3达到3时将其清除。
    // 在为每个位运行所有数字后，如果我们有1，则该1属于单个数字，我们可以通过执行以下操作将其移回原点ans |= sum << i;
    //这具有O（32n）的复杂度，本质上是O（n），非常容易思考和实现。
    //此外，您可以随时随地获得通用解决方案。说所有数字有5次，就做sum %= 5。
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            //对每个整数以32位表示，分别统计每一位上1的个数，最后该位数上的和对3取余数；
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            //如果余数不为0，则说明该位上只出现一次的元素，在该位上有1;
            //通过移位操作和1做位与运算，则可求得当前元素在该位是否有1。
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }
}
