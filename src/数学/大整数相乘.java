package 数学;

public class 大整数相乘 {
    /**
     * Karatsuba乘法
     * 普通乘法的复杂度是n2，而Karatsuba算法的复杂度仅为3nlog3≈3n1.585（log3是以2为底的）
     */
    public static long karatsuba(long num1, long num2){
        //x=a*10^(n/2)+b的形式，y=c*10^(n/2)+d的形式(halfN = Math.max(size1, size2) / 2;)

        //递归终止条件
        if(num1 < 10 || num2 < 10) return num1 * num2;

        // 计算拆分长度
        int size1 = String.valueOf(num1).length();
        int size2 = String.valueOf(num2).length();
        int halfN = Math.max(size1, size2) / 2;

        /* 拆分为a, b, c, d */
        long a = Long.valueOf(String.valueOf(num1).substring(0, size1 - halfN));
        long b = Long.valueOf(String.valueOf(num1).substring(size1 - halfN));
        long c = Long.valueOf(String.valueOf(num2).substring(0, size2 - halfN));
        long d = Long.valueOf(String.valueOf(num2).substring(size2 - halfN));

        // 计算z2, z0, z1, 此处的乘法使用递归
        //x*y=a*c*10^n+(ad+bc)*10^(n/2)+bd
        //ac=z2
        long z2 = karatsuba(a, c);
        //z0=bd
        long z0 = karatsuba(b, d);
        //z1=ad+bc=(a + b)*(c + d)-ac-bd=a + b)*(c + d)-z2-z0
        long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

        return (long)(z2 * Math.pow(10, (2*halfN)) + z1 * Math.pow(10, halfN) + z0);
    }

    public static void main(String[] args) {
        karatsuba(456787546,324553245);
    }




}
