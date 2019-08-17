package 设计模式.单例模式;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-14 21:38
 **/

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: zpc
 * @Description: CAS实现单例
 * @Create: 2019-08-14 21:38
 **/

//用CAS的好处在于不需要使用传统的锁机制来保证线程安全,CAS是一种基于忙等待的算法,依赖底层硬件的实现,相对于锁它没有线程切换和阻塞的额外消耗,可以支持较大的并行度。
// CAS的一个重要缺点在于如果忙等待一直执行不成功(一直在死循环中),会对CPU造成较大的执行开销。
public class CAS {

    private static final AtomicReference<CAS> INSTANCE = new AtomicReference<>();

    private CAS() {
    }

    public static CAS getInstance() {
        while (true) {
            CAS singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }
            singleton = new CAS();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}
