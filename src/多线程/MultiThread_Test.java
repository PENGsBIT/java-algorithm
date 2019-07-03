package 多线程;

import java.util.concurrent.*;

public class MultiThread_Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread mt = new MyThread();
        mt.start();
        //#############################################
        MyRunnable mr=new MyRunnable();
       new Thread(mr).start();
       //##############################################
        ExecutorService es = Executors.newSingleThreadExecutor();

        // 自动在一个新的线程上启动 多线程.MyCallable，执行 call 方法
        Future<?> f = es.submit(new MyCallable());

        // 当前 main 线程阻塞，直至 future 得到值
        System.out.println(f.get());

        es.shutdown();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


class MyRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class tpool{
    public void  run(){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,3,10,
            TimeUnit.SECONDS,new SynchronousQueue<>(),new ThreadPoolExecutor.DiscardOldestPolicy());
        try{
            threadPoolExecutor.execute(()-> System.out.println(Thread.currentThread().getName()));
        }finally {
            threadPoolExecutor.shutdown();
        }

    }


}


class MyCallable implements Callable<String> {
    public String call() {
        //System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Thread.currentThread().getName();
    }
}
