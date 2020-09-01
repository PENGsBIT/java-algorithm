package 贪心;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 田忌赛马 {

    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        //输入数据
//        for (int i = 0; i < n; ++i) {
//            list1.add(in.nextInt());
//        }
//        for (int i = 0; i < n; ++i) {
//            list2.add(in.nextInt());
//        }
        int n = 5;
        //输入数据
        for (int i = 0; i < n; ++i) {
            list1.add(i);
        }
        for (int i = 0; i < 2 * n; i += 2) {
            list2.add(i);
        }
        //处理数据
        Collections.sort(list1);
        Collections.sort(list2);

        boolean bLast = true;

        int i = 0, j = 0, x = n - 1, y = n - 1, count = 0;


        while (bLast) {
            //是否是最后一匹马
            if (x == i) {
                bLast = false;
            }
//如果田忌当前最好的马可以胜齐王最好的马，那么比一场
            if (list1.get(x) > list2.get(y)) {
                x--;
                y--;
                count += 200;
            } //如果田忌当前最差的马可以胜齐王最差的马，那么比一场
            else if (list1.get(i) > list2.get(j)) {
                i++;
                j++;
                count += 200;
            }//否则，让田忌最差的马和齐王最好的好比一场
            else {
                if (list1.get(i) < list2.get(y)) {
                    count -= 200;
                }
                i++;
                y--;
            }
        }
        System.out.println(count);
        list1.clear();
        list2.clear();

    }
}



