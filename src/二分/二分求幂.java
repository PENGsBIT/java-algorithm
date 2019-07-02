package 二分;

public class 二分求幂 {
    public static void main(String[] args) {
        System.out.println(myPow(1,3));
    }
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1.0/myPow(x, -n);
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return x * half * half;
    }

}
