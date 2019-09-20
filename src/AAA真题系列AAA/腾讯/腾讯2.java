package AAA真题系列AAA.腾讯;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 20:52
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zpc
 * @Description:
 * 小Q有M(M为偶数)名员工, 第i名员工完成工作的时候有一个拖延时间值
 *  现在小Q手里有M/2份工作需要完成, 每一份工作都需要安排两名员工参与, 对于第i份工作所需完成的时间为两名员工的拖延时间值总和。
 *    现在M/2份工作同时开始进行,小Q希望所有工作结束的时间尽量早, 请你帮小Q设计一个优秀的员工分配方案,使得用尽量少的时间完成所有工作,并输出工作所需的最短时间。
 *    拖延值为8的和拖延值为2的组队，两名拖延值为5的组队，所以完成工作的时间为10，这是时间最短的方案。
 * 3
 * 1 8
 * 2 5
 * 1 2
 * 10
 * @Create: 2019-09-20 20:52
 **/


public class 腾讯2 {

    private static List<People> workers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            int time = scanner.nextInt();
            workers.add(new People(count, time));
        }
        System.out.println(findMinTime(n));
        ;
    }


    public static int findMinTime(int n) {
        workers.sort((w1, w2) -> w1.time - w2.time);
        int i = 0, j = workers.size() - 1;
        int ans = 0;
        while (i <= j) {
            ans = Math.max(workers.get(i).time + workers.get(j).time, ans);
            workers.get(i).num--;
            workers.get(j).num--;
            if (workers.get(i).num <= 0) {
                i++;
            }
            if (workers.get(j).num <= 0) {
                j--;
            }
        }
//        System.out.println(ans);
        return ans;
    }


}

class People {
    int num;
    int time;

    public People(int count, int time) {
        this.num = count;
        this.time = time;
    }


}
