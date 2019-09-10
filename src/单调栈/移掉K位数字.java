package 单调栈;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-10 10:24
 **/

/**
 * @Author: zpc
 * @Description: leetcode402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @Create: 2019-09-10 10:24
 **/


public class 移掉K位数字 {
    public static String removeKdigits(String num, int k) {
        //n是 num 的长度，我们要去除k个，那么需要剩下 n-k 个
        int digits = num.length() - k;
        //维护一个递增栈，只要发现当前的数字小于栈顶元素的话，就将栈顶元素移除，
        // 比如点那个遍历到2的时候，栈里面有1和3，此时2小于栈顶元素3，那么将3移除即可。
        // 为何一定要移除栈顶元素呢，后面说不定有更大的数字呢？这是因为此时栈顶元素在高位上，
        // 就算后面的数字再大，也是在低位上，我们只有将高位上的数字尽可能的变小，才能使整个剩下的数字尽可能的小。
        char[] stk = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        //根据题目中的描述，可能会出现 "0200" 这样不符合要求的情况，
        // 所以我们用一个 while 循环来去掉前面的所有0，然后返回时判断是否为空，为空则返回 “0”
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
    }
}
