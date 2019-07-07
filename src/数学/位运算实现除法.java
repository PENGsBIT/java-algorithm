package 数学;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-07 22:59
 **/

public class 位运算实现除法 {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int i,total = 0;
        //判断正负号
        boolean sign = ((dividend < 0) ^ (divisor < 0));
        //这里必须要long,因为如果最小值取绝对值会溢出
        long did = Math.abs((long)dividend);
        long dis = Math.abs((long)divisor);
        while(did >= dis)
        {
            long mul_dis = dis;
            i = 0;
            //每次左移乘2，记录下来，直到不能减
            while(did >= (mul_dis<<1))
            {
                i++;
                mul_dis <<= 1;
            }
            did -= mul_dis;
            total += 1<<i;
        }
        //根据符号返回
        return sign?-total:total;
    }
}
