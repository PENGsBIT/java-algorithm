package 数学;

/**
 * @Author: zpc
 * @Description: 字节面试题
 * @Create: 2019-07-16 23:11
 **/

//1/3=-0.(3)
public class 带小数除法 {
    public static void main(String[] args) {
        System.out.println(devide(9, 3));
    }

    public static String devide(int a, int b) {
        int i = Math.abs(a);
        int j = Math.abs(b);
        String res = "";
        if (i < j) {
            //除法出来使小数
            res += "0.";
            res=core(res, i, j);
        } else {
            int k=i,count=0;
            while (k - j >= 0) {
                int temp=k-j;
                k=temp>0?temp:k;
                count++;
                if (temp == 0) {
                    res+=""+count+".0";
                    return res;
                }
            }
            res+=""+count+".";
            res=core(res,k,j);
        }
        if (a * b < 0) {
            res="-"+res;
        }
        return res;
    }

    private static String core(String res, int i, int j) {
        //控制位数
        int wei = 0, yu = 0;
        i *= 10;
        int k=i;
        loop:while (wei <= 10) {
            while (k - j > 0) {
                int temp=k-j;
                k=temp>0?temp:k;
                yu++;
            }
            if (k * 10 == i) {
                res += "(" + yu + ")";
                break loop;
            } else {
                res += "" + yu;
            }
            wei++;
        }
        return res;
    }


}
