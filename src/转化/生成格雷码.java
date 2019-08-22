package 转化;

import java.util.Arrays;

//在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
//
//给定一个整数n，请返回n位的格雷码，顺序为从0开始。
//
//测试样例：
//1
//返回：["0","1"]
public class 生成格雷码 {
    ////递归
    //
    //    //递归的思路是n位gray码是由n-1位gray码生成，举个例子简单一些：
    //
    //    //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
    //
    //    //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
    //
    //    //添加1后需要顺序反向就变成(110,111,101,100)
    //
    //    //组合在一起就是(000,001,011,010,110,111,101,100)
    public static String[] getGray(int n) {
        String[] ret;
        if(n == 1){
            ret = new String[]{"0","1"};
        }else{
            String[] lastGray = getGray(n-1);
            //格雷码的个数为2的n次方。如n=3时，有8个格雷码。
            ret = new String[2*lastGray.length];
            for(int i=0; i<lastGray.length; i++){
                ret[i] = "0"+lastGray[i];
                ret[ret.length-1-i] = "1"+lastGray[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGray(3)));
    }
}
