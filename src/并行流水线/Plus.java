package 并行流水线;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 13:39
 **/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: zpc
 * @Description: 计算的加法
 * P1从共享管道BlockingQueue取出Msg，然后使用Msg封装的i和j进行求和操作，然后通过把结果添加到P2的共享管道BlockingQueue，传递给P2
 * @Create: 2019-09-20 13:39
 **/


public class Plus implements Runnable{

    public static BlockingQueue<Msg> bg=new LinkedBlockingQueue<Msg>();
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            try {
                Msg msg=bg.take();
                msg.j=msg.i+msg.j;
                Multiply.bg.add(msg);
            } catch (Exception e) {

            }
        }
    }
}

