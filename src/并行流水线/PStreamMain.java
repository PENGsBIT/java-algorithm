package 并行流水线;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 13:38
 **/



/**
 * @Author: zpc
 * @Description:
 * 并发流水线是通过BlockingQueue这个共享管道，
 * 通过依赖关系串联起来，把操作分配在不同线程中进行计算，尽可能利用多核优势
 * 可以借鉴日常生产中的流水线思想，首先将计算过程拆分为三个步骤：
 * P1:A=B+C
 * P2:D=AxB
 * P3:D=D/2
 * 上述步骤中P1、P2和P3均在单独的线程中计算，并且每个线程只负责自己的工作。此时，P3的计算结果就是最终需要的答案。
 * @Create: 2019-09-20 13:38
 **/


public class PStreamMain {
    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                Msg msg=new Msg();
                msg.i=i;
                msg.j=j;
                msg.orgStr="(("+i+"+"+j+")*"+i+")/2";
                Plus.bg.add(msg);
            }

        }
    }
}
