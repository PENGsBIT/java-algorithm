import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yue {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入总人数：");
//        int totalNum = scanner.nextInt();
//        System.out.print("请输入第k开始：");
//        int k = scanner.nextInt();
//        System.out.print("请输入报数的大小：");
//        int cycleNum = scanner.nextInt();
//        yuesefu(totalNum, k, cycleNum);
//    }

    public static void yuesefu(int totalNum, int k, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //从第K个开始计数
        k = k - 1;
        while (start.size() > 0) {
            k = k + countNum;
            //第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }
}
