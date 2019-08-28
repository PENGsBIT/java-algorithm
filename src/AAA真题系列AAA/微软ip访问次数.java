package AAA真题系列AAA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class 微软ip访问次数 {
    //查找在1s中以内ip是否查询超过100次
    static Map<String, LinkedList<Long>> ipAccess = new HashMap<>();
    static Random random=new Random();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread.sleep(random.nextInt(1000));
            ipIn();
        }
    }

    //模拟多次ip访问
    private static void ipIn() {
        long time = System.currentTimeMillis();
        String ip = "IP1";

        boolean flag=random.nextBoolean();
//        if (flag) {
//            ip = "IP2";
//        }
        if (checkIp(time, ip)) {
            System.out.println(ip+":access.....");
        } else {
            System.out.println("IP:"+ip+" Access 3 times less than 1s");
        }
    }

    //只需要长度为10，后来的请求覆盖掉之前的请求，然后判断最新的一个请求和队列中最早的请求时间差是否>=1。
    //>说明ip在一秒内访问次数小于k
    private static boolean checkIp(long time, String ip) {
        if (ip.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (ipAccess.containsKey(ip)) {
            LinkedList<Long> curIPAccess = ipAccess.get(ip);
            curIPAccess.add(time);
            if (curIPAccess.size() > 3) {
                curIPAccess.poll();
            }
            long peek = curIPAccess.peekFirst();
            if (time - peek <= 1000 && curIPAccess.size() == 3) {
                System.out.println();
                System.out.println(curIPAccess);
                System.out.println(time - peek);
                return false;
            } else {
                System.out.println();
                System.out.println(curIPAccess);
                System.out.println(time - peek);
                return true;
            }
        } else {
            ipAccess.computeIfAbsent(ip, k -> new LinkedList<>()).add(time);
        }
        return true;

    }
}
