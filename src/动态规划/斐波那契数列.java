package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-25 14:58
 **/

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-25 14:58
 **/


public class 斐波那契数列 {

    public int Fibonacci(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;

    }
}
