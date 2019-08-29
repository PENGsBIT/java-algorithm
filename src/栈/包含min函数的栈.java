package 栈;

import java.util.Arrays;
import java.util.Stack;

//剑指offer
//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
public class 包含min函数的栈 {


    private static int size=0;
    private static int curMin = Integer.MAX_VALUE;
    private static Stack<Integer> minStack = new Stack<>();
    private static Integer[] elements = new Integer[10];
    public static void push(int node) {
        elements[size++] = node;
        if(node <=curMin){
            minStack.push(node);
            curMin = node;
        }
    }


    public static int pop() {
        int popNum=elements[size-1];
        elements[size--] = null;
        if (popNum == curMin) {
            minStack.pop();
            curMin = minStack.peek();
        }
        return popNum;
    }



    public static int min() {
        return curMin;
    }

    public static void main(String[] args) {
        push(8);
        push(7);
        push(5);
        push(5);
        System.out.println("cur min:"+min());
        push(6);
        push(3);
        System.out.println("cur min:"+min());
        pop();
        System.out.println("stack pop 3:"+ Arrays.toString(elements));
        System.out.println("cur min:"+min());
        pop();
        System.out.println("stack pop 6:"+ Arrays.toString(elements));
        System.out.println("cur min:"+min());
        pop();
        System.out.println("stack pop 5:"+ Arrays.toString(elements));
        System.out.println("cur min:"+min());
    }
}
