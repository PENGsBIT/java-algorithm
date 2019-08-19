package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-19 21:34
 **/

import java.util.Scanner;

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-08-19 21:34
 **/


public class 矩形相交区域 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int x1 = sca.nextInt();
        int y1 = sca.nextInt();
        int w1 = sca.nextInt();
        int h1 = sca.nextInt();
        int x2 = sca.nextInt();
        int y2 = sca.nextInt();
        int w2 = sca.nextInt();
        int h2 = sca.nextInt();
        join(x1, y1, w1, h1, x2, y2, w2, h2);
    }
    private static void join(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
        boolean flag = false;
        int xa1 = x1, ya1 = y1, xa2 = x1 + w1, ya2 = y1 + h1;
        int xb1 = x2, yb1 = y2, xb2 = x2 + w2, yb2 = y2 + h2;
        int xa3 = (xa1 + xa2) / 2, ya3 = (ya1 + ya2) / 2;
        int xb3 = (xb1 + xb2) / 2, yb3 = (yb1 + yb2) / 2;
        flag = Math.abs(xb3 - xa3) <= ((xa2 - xa1) / 2 + (xb2 - xb1) / 2) && Math.abs(yb3 - ya3) <= ((ya2 - ya1) / 2 + (yb2 - yb1) / 2);
        if (flag) {
            int cx1 = Math.max(x1, x2);
            int cy1 = Math.max(y1, y2);
            int cx2 = Math.min(w1, w2);
            int cy2 = Math.min(h1, h2);
            System.out.printf("%d %d %d %d ", cx1, cy1, cx2, cy2);
        } else {
            System.out.println("null");
        }

    }

}
