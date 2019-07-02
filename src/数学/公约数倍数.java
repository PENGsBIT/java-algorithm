package 数学;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-01 22:04
 **/

public class 公约数倍数 {

    public static void main(String[] args) {
        System.out.println(gongbei(24, 60));;
    }

    private static int gongbei(int n1, int n2) {
        if (n1 > n2) {
            //求MAX公约数
            //辗转向余法
            int n = n1, m = n2;
            while (n % m != 0) {
                int temp =n%m;
                n=m;
                m=temp;
            }
            //m=MAX公约数
            //max公倍数=n1*n2/max公约数
            return n1*n2/m;
        } else {
            return gongbei(n2, n1);
        }
    }

}
