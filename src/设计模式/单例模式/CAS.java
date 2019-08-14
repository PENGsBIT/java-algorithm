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
