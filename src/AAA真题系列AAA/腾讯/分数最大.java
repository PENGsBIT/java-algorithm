package AAA真题系列AAA.腾讯;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-01 22:38
 **/

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: zpc
 * @Description: 腾讯4
 * n天每天一个值i,时间段评分为在这段时间中的最小i与分数总合的乘积，求这个数组的最高得分
 * 例如：
 * 5
 * 7 2 4 6 5
 * 最高的分60,3-5天最小值4*（4+6+5）=60
 * @Create: 2019-09-01 22:38
 **/


public class 分数最大 {
    //当最低分固定时，为了使学习状态评分最高，应当把左右连续的并且大于等于当前最低分的都包含到区间内。
    //可以用栈做，所有元素需要入栈出栈依次，时间复杂度O(n)。
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] score=new long[n+2];
        long[] sum=new long[n+2];
        for(int i=1;i<=n;i++){
            score[i]=scanner.nextLong();
            sum[i]=sum[i-1]+score[i];
        }
        score[n+1]=0;
        sum[n+1]=sum[n];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int i=1;
        long ans=0;
        while(!stack.isEmpty()){
            while(i==n+1||(stack.peek()!=0)&&score[stack.peek()]>score[i]){
                int top=stack.pop();
                if(top==0)  break;
                ans=Math.max(ans,score[top]*(sum[i]-sum[stack.peek()]-score[i]));
            }
            if(i<=n)  stack.push(i++);
        }
        System.out.println(ans);
    }
}
