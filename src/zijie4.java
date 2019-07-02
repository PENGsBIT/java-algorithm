import java.util.Scanner;

public class zijie4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];

        double min = 0, max = 0, mid, fin = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            max = Math.max(a[i], max);
        }

        while (!(max - min < 0.0001)) {
            mid = (min + max) / 2;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp = temp + (int) Math.floor(a[i] / mid);
            }
            if (temp >= m) {
                min = mid;
                fin = mid;
            } else {
                max = mid;
            }
        }
        //System.out.print(fin);
        System.out.printf("%.2f", fin);
    }
}
