import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 买书问题 {
    //    上柜的《哈利波特》平装本系列，一共有五卷。假设每一卷单独销售均需8欧元。如果读者一次购买不同的两卷，就可以扣除5%的费用，三卷则更多。假设具体折扣的情况如下：
//
//                    本数    2       折扣   5%
//
//                    本数    3       折扣  10%
//
//                    本数    4       折扣  20%
//
//                    本数    5       折扣  25% 
//
//    问题：设计出算法，能够计算出读者所购买的一批书的最低价格。
    public static void main(String[] args) {
        //float min = internalCalc(0, 2, 2, 1, 2);
        //System.out.println("[0,2,2,1,2]最小花费：" + min+"  greed"+(4*0.8+3*0.9));
        System.out.println("[1,2,2,2,1] min cost=" + internalCalc(1, 2, 2, 2, 1) * 8);
    }


    public static float internalCalc(int n1, int n2, int n3, int n4, int n5) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        Collections.sort(list);
        n1 = list.get(4);
        n2 = list.get(3);
        n3 = list.get(2);
        n4 = list.get(1);
        n5 = list.get(0);

        float minCost = n1 + n2 + n3 + n4 + n5;
        if (n5 >= 1) {
            float tmp = 5 * (1 - 0.25f) + internalCalc(n1 - 1, n2 - 1, n3 - 1, n4 - 1, n5 - 1);
            minCost = minCost < tmp ? minCost : tmp;
        }

        if (n4 >= 1) {
            float tmp = 4 * (1 - 0.2f) + internalCalc(n1 - 1, n2 - 1, n3 - 1, n4 - 1, n5);
            minCost = minCost < tmp ? minCost : tmp;
        }

        if (n3 >= 1) {
            float tmp = 3 * (1 - 0.10f) + internalCalc(n1 - 1, n2 - 1, n3 - 1, n4, n5);
            minCost = minCost < tmp ? minCost : tmp;
        }

        if (n2 >= 1) {
            float tmp = 2 * (1 - 0.05f) + internalCalc(n1 - 1, n2 - 1, n3, n4, n5);
            minCost = minCost < tmp ? minCost : tmp;
        }

        if (n1 >= 1) {
            float tmp = 1 + internalCalc(n1 - 1, n2, n3, n4, n5);
            minCost = minCost < tmp ? minCost : tmp;
        }

        if (n1 < 1) {
            float tmp = 0;
            minCost = minCost < tmp ? minCost : tmp;
        }

        return minCost;
    }

}

class buybook2 {
    public static double Min(double a, double b, double c, double d, double e) //返回最小值

    {

        double A[] = {a, b, c, d, e};

        Arrays.sort(A);

        return A[0];

    }


    public static double BuyBook(int a, int b, int c, int d, int e) {

        //把要买的书的数目按从小到大排序,因为每种书价钱一样,所以一种书放在哪个位置无所谓

        int n[] = {a, b, c, d, e};

        Arrays.sort(n);

        a = n[0];

        b = n[1];

        c = n[2];

        d = n[3];

        e = n[4];


        final double large = Double.MAX_VALUE; //定义一个很大的值,去最小值时不会取到这个值


        if (n[0] > 0) //数目最少的书都至少有一本,因此此轮可以买1, 2, 3, 4, 5,本都行,去最小值,再递归

        {

            return Min(8.0 + BuyBook(a, b, c, d, e - 1),

                    2 * 8.0 * 0.95 + BuyBook(a, b, c, d - 1, e - 1),

                    3 * 8.0 * 0.9 + BuyBook(a, b, c - 1, d - 1, e - 1),

                    4 * 8.0 * 0.80 + BuyBook(a, b - 1, c - 1, d - 1, e - 1),

                    5 * 8.0 * 0.75 + BuyBook(a - 1, b - 1, c - 1, d - 1, e - 1));

        } else if (n[0] == 0 && n[1] > 0) //数目最少的一种没了,就不能5种都买了

        {

            return Min(8.0 + BuyBook(a, b, c, d, e - 1),

                    2 * 8.0 * 0.95 + BuyBook(a, b, c, d - 1, e - 1),

                    3 * 8.0 * 0.9 + BuyBook(a, b, c - 1, d - 1, e - 1),

                    4 * 8.0 * 0.80 + BuyBook(a, b - 1, c - 1, d - 1, e - 1),

                    large);

        } else if (n[0] == 0 && n[1] == 0 && n[2] > 0) //数目最少的2种没了,最多买3种

        {

            return Min(8.0 + BuyBook(a, b, c, d, e - 1),

                    2 * 8.0 * 0.95 + BuyBook(a, b, c, d - 1, e - 1),

                    3 * 8.0 * 0.9 + BuyBook(a, b, c - 1, d - 1, e - 1),

                    large,

                    large);

        } else if (n[0] == 0 && n[1] == 0 && n[2] == 0 && n[3] > 0) //数目最少的3种没了,最多买2种

        {

            return Min(8.0 + BuyBook(a, b, c, d, e - 1),

                    2 * 8.0 * 0.95 + BuyBook(a, b, c, d - 1, e - 1),

                    large,

                    large,

                    large);

        } else if (n[0] == 0 && n[1] == 0 && n[2] == 0 && n[3] == 0 && n[4] > 0) //数目最少的4种没了,最多买1种

        {

            return 8.0 + BuyBook(a, b, c, d, e - 1);

        } else {

            return 0;

        }


    }


    public static void main(String[] args) {
        int n[] = {1, 2, 2, 1, 2};
        System.out.println(BuyBook(n[0], n[1], n[2], n[3], n[4]));
    }
}
