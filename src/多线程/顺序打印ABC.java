package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 顺序打印ABC {

}
class Synchronized_ABC {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {// 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) { // 先获取 prev 锁
                    synchronized (self) {// 再获取 self 锁
                        System.out.print(name);// 打印
                        count--;
                        self.notify();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                    }
                    // 此时执行完self的同步块，这时self锁才释放。
                    try {
                        if (count == 0) {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            prev.notifyAll();
                        } else {
                            prev.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadPrinter pa = new ThreadPrinter("A", c, a);
        ThreadPrinter pb = new ThreadPrinter("B", a, b);
        ThreadPrinter pc = new ThreadPrinter("C", b, c);

        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
        new Thread(pc).start();
        Thread.sleep(10);
    }
}

class Lock_State_ABC {
    private static Lock lock=new ReentrantLock();
    private static int state=0;//通过state的值来确定是哪个线程打印

    static class ThreadA extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==0){// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }


    static class ThreadC extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==2){
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}

class Lock_Condition_ABC {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();

                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0){//注意这里是不等于0，也就是说没轮到该线程执行，之前一直等待状态
                        A.await(); //该线程A将会释放lock锁，构造成节点加入等待队列并进入等待状态
                    }
                    System.out.print("A");
                    count++;
                    B.signal(); // A执行完唤醒B线程
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1)
                        B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                    System.out.print("B");
                    count++;
                    C.signal();// B执行完唤醒C线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2)
                        C.await();// C释放lock锁
                    System.out.print("C");
                    count++;
                    A.signal();// C执行完唤醒A线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}

class Atomtic_ABC {

    private AtomicInteger ai = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3 * 10;

    private class RunnableA implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE-1) {
                if (ai.get() % 3 == 0) {
                    System.out.print("A");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableB implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 1) {
                    System.out.print("B");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 2) {
                    System.out.println("C");
                    ai.getAndIncrement();
                }
            }

        }
    }


    public static void main(String[] args) {
        Atomtic_ABC atomic_ABC = new Atomtic_ABC();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(atomic_ABC.new RunnableA());
        service.execute(atomic_ABC.new RunnableB());
        service.execute(atomic_ABC.new RunnableC());

        service.shutdown();
    }
}
