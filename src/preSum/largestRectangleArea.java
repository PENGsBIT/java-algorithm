package preSum;

import java.util.Arrays;
import java.util.Stack;

public class largestRectangleArea {
    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        //System.out.println(Arrays.toString(a[0]));
        System.out.println(largestRectangleArea2(a));
    }
    public static int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length+1];
        //后面看作高度为0
        h = Arrays.copyOf(height, height.length+1);
        while(i < h.length){
            //如果栈是空的，那么索引i入栈。那么第一个i=0就进去吧。注意栈内保存的是索引，不是高度。然后i++。
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                //当i=1的时候，发现h[i]小于了栈内的元素，于是出栈。（由此可以想到，哦，看来stack里面只存放单调递增的索引）
                int t = stack.pop();
                //这时候stack为空，所以面积的计算是h[t] * i.t是刚刚弹出的stack顶元素。
                //System.out.println(stack.peek());
                //System.out.println(i - stack.peek() - 1);
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
