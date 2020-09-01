package 位运算;

/**
 * @Program: java-algorithm
 * @Author: zhoupengcheng03
 * @Package: 位运算
 * @ClassName: 奇偶数
 * @Description:
 * @Create: 2020-09-01 12:02
 **/
public class 奇偶数 {
    //    1的二进制 表示形式为 00000001
    //所以：
    //任何整数 & 1
    //  结果为 1 ，则为奇数
    //  结果为 0 ，则为偶数
    public boolean isOdd(int a) {
        return (a & 1) == 1;
    }

}
