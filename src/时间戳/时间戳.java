package 时间戳;

public class 时间戳 {
    public static void main(String[] args) throws InterruptedException {
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        Thread.sleep(5000);
        long time2 = System.currentTimeMillis();
        System.out.println(time2);
        System.out.println(time2-time1);
    }
}
