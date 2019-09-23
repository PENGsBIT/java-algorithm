package AAA真题系列AAA.腾讯;
/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-20 22:06
 **/

import java.util.Scanner;

public class 腾讯4 {

    private static int[] a;
    private static int n;

    private static void down(int x) {
        int y = x << 1;
        while (y <= n) {
            if (y < n && a[y] > a[y + 1]) {
                y++;
            }
            if (a[x] > a[y]) {
                int t = a[x];
                a[x] = a[y];
                a[y] = t;
                x = y;
                y = y << 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = (n >> 1); i >= 1; i--) {
            down(i);
        }
        int dec = 0;
        for (; k > 0; k--) {
            int ans = 0;
            while (ans == 0 && n > 0) {
                ans = a[1] - dec;
                a[1] = a[n];
                n--;
                down(1);
            }
            System.out.println(ans);
            dec += ans;
        }

    }

}
