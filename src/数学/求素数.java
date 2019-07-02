package 数学;

import java.util.ArrayList;
import java.util.List;

public class 求素数 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(findPrime1(10000).size());
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        System.out.println(findPrime2(10000).size());
        System.out.println(System.nanoTime() - time);

        time = System.nanoTime();
        System.out.println(findPrime3(10000).size());
        System.out.println(System.nanoTime() - time);
    }

    public static List<Integer> findPrime1(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i <= n; i++) {
            for(int j = 2; j < i; j++) {
                if(i % j == 0)	break;
                if(j == i-1)	primes.add(i);
            }
        }
        return primes;
    }

    public static List<Integer> findPrime2(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i <= n; i++) {
            int tmp = (int)Math.sqrt(i) + 1;
            for(int j = 2; j <= tmp; j++) {
                if(i % j == 0)	break;
                if(j == tmp)	primes.add(i);
            }
        }
        return primes;
    }
    /**
     * 判断 n 是否能被整除
     * @param n   要判断的数字
     * @return 如果 n 能被 primes 中任何一个整除，则不是素数。
     */
    public static List<Integer> findPrime3(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        loop:for(int i = 3; i <= n; i+=2) {
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    continue loop;
                }
            }
            primes.add(i);
        }
        return primes;
    }


}
