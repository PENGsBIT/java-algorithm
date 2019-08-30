package AAA真题系列AAA.微软;

//220的真因数之和为：1+2+4+5+10+11+20+22+44+55+110=284
//
//284的真因数之和为：1+2+4+71+142=220
//
//毕达哥拉斯把这样的数对A、B称为相亲数：A的真因数之和称为B，而B的真因数之和为A。求100000以内的相亲数。
public class 相亲数 {
    public static void main(String[] args) {
        int sA = 0;   //A的真因数之和
        int sB = 0;   //B的真因数之和
        for(int i=1;i<100001;i++){  //题目要求求出100000以内的相亲数，所以需要遍历从1到100001,循环里的i就是A
            sA = getSum(i);
            //再回到这行代码，把i这个值传到了方法中，让方法去进行因数求和运算，把算下来的值又给了sA
            //要满足两个条件：sA==B,sB==A。那这个B怎么弄,是不是又要循环下呢？不用那么麻烦
            //我们现在就假设sA等于B成立，即假设B==sA已经符合了，B就是sA。接下来就只要验证B的因数之和是不是等于A即可
            sB = getSum(sA);    //刚才假设了现在的B就sA，所以算B的因数之和，也就是要算sA的因数之和。所以把sA传入getSum这个方法中
            //返回的值就是 sB了
            if(sA>i){  //避免重复，要不然如果A和B相等了，就等于这个数的本身就是自己的相亲数，就没有意义了。
                //也不能写sA!=i,那样的话就会出现“220和284是一对相亲数，284和220是一对相亲数”这种情况
                if(sB==i){   //做逻辑判断，因为已经假设了B==sA，所以现在只要验证A是否等于sB就行了
                    System.out.println(i+"和"+sA+"是一对相亲数");  //如果满足，就把这个打印出来
                }
            }
        }
    }
    public static int getSum(int num){
        int sum = 0;  //定义变量用来表示因数的和
        for(int i=1;i<num;i++){   //要求因数的和，就要知道因数是什么，所以需要从1开始遍历整个数
            if(num%i==0){   //如果这个数和i相除的余数是0，那么就说明i是这个数的一个因数
                sum = sum+i;   //每符合一个，就把这个因数加到sum里面
            }
        }
        return sum;  //将这个sum作为返回值，即传入的num的因数的和
    }

}
