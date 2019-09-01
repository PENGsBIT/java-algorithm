package AAA真题系列AAA.腾讯;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-01 22:49
 **/

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: zpc
 * @Description: 排队贪心
 *
 * 将a(j - 1) + b(n - j) 拆开成value =（a - b)j - a + bn,j表示位置，将value最大的排在最前面，就可以得到结果
 *  * 用优先队列做贪心算法(a - b) * postion - a + b * n,postion表示位置
 *  n个人，每个人两个属性（a,b)，满意度a(j - 1) + b(n - j)，j为当前第几位
 * @Create: 2019-09-01 22:49
 **/


public class 排队 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Queue<Person> queue = new PriorityQueue<>((i, j) -> (int) ((j.a - j.b) - (i.a - i.b)));
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            queue.offer(new Person(a, b));
        }

        long result = 0;
        int postion = 1;
        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            long qValue = (tmp.a - tmp.b) * postion - tmp.a + tmp.b * n;
            result += qValue;
            postion++;
        }

        System.out.println(result);
    }
}

class Person {
    long a;
    long b;

    public Person(long a, long b) {
        this.a = a;
        this.b = b;
    }
}
