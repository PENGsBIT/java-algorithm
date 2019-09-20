package 并行流水线;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 13:40
 **/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: zpc
 * @Description: 计算的乘法
 * @Create: 2019-09-20 13:40
 **/


public class Multiply implements Runnable {
    public static BlockingQueue<Msg> bg=new LinkedBlockingQueue<Msg>();
    @Override
    public void run() {
        while(true){
            try {
                Msg msg=bg.take();
                msg.i=msg.i*msg.j;
                Div.bg.add(msg);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

}

