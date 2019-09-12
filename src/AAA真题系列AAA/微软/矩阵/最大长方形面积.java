package AAA真题系列AAA.微软.矩阵;

import java.util.Arrays;
import java.util.Stack;

//leetcode 84. 柱状图中最大的矩形
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
//        1
//     1  1
//     1  1
//     1  1   1
// 1   1  1 1 1
// 1 1 1  1 1 1
//
//以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//        1
//     x  x
//     x  x
//     x  x   1
// 1   x  x 1 1
// 1 1 x  x 1 1
//图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
// 
//
//示例:
//
//输入: [2,1,5,6,2,3]
//输出: 10
//
public class 最大长方形面积 {
    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        //System.out.println(Arrays.toString(a[0]));
        System.out.println(largestRectangleArea2(a));
    }
    //辅助栈法（网上很多人采用的方法）
    //


    public static int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int rightBound = 0;
        int maxArea = 0;
        int[] h = new int[height.length+1];
        //后面看作高度为0
        h = Arrays.copyOf(height, height.length+1);
        while(rightBound < h.length){
            //如果栈是空的，那么索引i入栈。那么第一个i=0就进去吧。注意栈内保存的是索引，不是高度。然后i++。
            if(stack.isEmpty() || h[stack.peek()] <= h[rightBound]){
                System.out.println("stack push index:"+rightBound);
                stack.push(rightBound++);
            }else {
                //当i=1的时候，发现h[i]小于了栈内的元素，于是出栈。（由此可以想到，哦，看来stack里面只存放单调递增的索引）
                int leftBound = stack.pop();
                //这时候stack为空，所以面积的计算是h[t] * i.t是刚刚弹出的stack顶元素。
                if (!stack.isEmpty()) {
                    System.out.println("stack peek:" + stack.peek());
                    System.out.println("i-stack.peek-1:"+(rightBound - stack.peek() - 1));
                } else {
                    System.out.println("stack null");
                }
                System.out.println("now left bound:"+leftBound);

                maxArea = Math.max(maxArea, h[leftBound] * (stack.isEmpty() ? rightBound : rightBound - stack.peek() - 1));
            }
        }
        return maxArea;
    }
    //左右扫描法
    //考虑到最大面积的矩形高度一定跟某个条一样高，所以挨个枚举每个条，
    // 看其向左、向右最多能延伸到多远。在计算左右边界时，可以借助之前计算过的结果迭代
    // （类似动归的感觉）优化以减少时间复杂度，这应该算是唯一的难点了。
    // 总的来说，向左一遍，向右一遍，整体求面积再一遍，一共需要3次遍历，时间复杂度是O(n)。
    //
    //左右扫描法非常直观。
    int largestRectangleArea(int[]height) {
        if (height.length == 0) {
            return 0;
        }

        int n = height.length;
        int maxArea = 0;
        int []left = new int[n]; // 向左能延伸多远
        int []right = new int[n]; // 向右能延伸多远

        // 向右延伸
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > height[i + 1])
                right[i] = 1;
            else {
                int j = i + 1;
                while (j < n && height[j] >= height[i])
                    j += right[j];
                right[i] = j - i;
            }
        }

        // 向左延伸
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (height[i] < height[i - 1])
                left[i] = 1;
            else {
                int j = i - 1;
                while (j >= 0 && height[j] >= height[i])
                    j -= left[j];
                left[i] = i - j;
            }
        }

        // 求面积
        maxArea = height[0];
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(height[i] * (left[i] + right[i] - 1), maxArea);
        }

        return maxArea;
    }
}
