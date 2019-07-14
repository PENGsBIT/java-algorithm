package 数学;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 13:24
 **/

public class 求1到n的和 {
    public static int Sum_Solution(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }
        int sum = n;
        sum+=Sum_Solution(n - 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }
}
