package 数学;

//某个袋子中有红球m个，白球n个。现在要从中取出x个球。那么红球数目多于白球的概率是多少呢？
//下面的代码解决了这个问题。其中的y表示红球至少出现的次数。
//这与前文的问题是等价的。因为如果取30个球，要求红球数大于白球数，则等价于至少取出16个红球。x/2+1
public class 红白球概率问题 {

    public static double redMore(int m, int n, int x, int y)
    {
        //需要取的球少于至少要取的红球 or 红球总数少于至少要取的红球
        if(y>x||y>m) return 0;
        ////至少取的红球是0
        if(y==0) return 1;
        //取出all白球后，还要取的球比至少要取的红球多
        if(x-n>=y) return 1;
        //取出红球之后的概率
        double pred = redMore(m-1,n,x-1,y-1);
        //取出白球之后的概率
        double pwhite = redMore(m,n-1,x-1,y);
        //m/(m+n)是第一个球是红球的概率，再调用递归求接下来再取到红球概率
        //n/(m+n)是第一个球是白球的概率，调用递归求接下来取到红球概率，两者情况相加即可
        return (double)m/(m+n) * pred + (double)n/(m+n) * pwhite;
    }

    public static void main(String[] args) {
        System.out.println(redMore(5, 5, 3, 5/2+1));
    }

}
