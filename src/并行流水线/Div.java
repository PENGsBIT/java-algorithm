package 并行流水线;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 13:39
 **/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-20 13:39
 **/

public class Div implements Runnable {
    public static BlockingQueue<Msg> bg = new LinkedBlockingQueue<Msg>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg=bg.take();
                msg.i=msg.i/2;
                System.out.println(msg.orgStr+"="+msg.i);
            } catch (Exception e) {
            }
        }
    }
}

