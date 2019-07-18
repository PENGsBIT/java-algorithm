package 栈;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-17 09:38
 **/

import java.util.Stack;

/**
 * @Author: zpc
 * @Description: 验证入栈是否符合出栈
 * @Create: 2019-07-17 09:38
 **/


public class 栈的出入顺序 {
    public static void main(String[] args) {
        int[] ru = {1, 2, 3, 4, 5};
        int[] chu1 = {4, 5, 3, 2, 1};
        int[] chu2 = {4, 3, 5, 1, 2};
        System.out.println(isOrder(ru,chu1));
        System.out.println(isOrder(ru,chu2));
    }

    public static boolean isOrder(int[] in, int[] out) {
        Stack<Integer> stack = new Stack<>();
        int outIndex=0;
        for (int i : in) {
            stack.push(i);
            while (outIndex < out.length && stack.peek() == out[outIndex]) {
                stack.pop();
                outIndex++;
            }
        }
        return stack.isEmpty();
    }
}
