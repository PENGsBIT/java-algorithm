package AAA真题系列AAA.微软;

public class 整数数组中两两之差绝对值最小的值 {
    //常规思路：对数组进行排序，便可以循环一遍数组，记下两两之间绝对值的最小值，那么所求得到值便是解答，总的时间复杂度是O(n*logn)
    //辅助数组是这样一个数组，设它为Bn.原来题目中给定的数组是An,则Bn等于：
    //
    //　　B1 = A1 - A2;
    //
    //　　B2 = A2 - A3;
    //
    //　　B3 = A3 - A4;
    //
    //　　......
    //
    //　　Bn-1 = An-1 - An.
    //
    //　　注意，Bn的长度是n-1，正好比An要小一个。
    //转化为求Bn的绝对值最小的最长连续子序列和，因为Bn的连续子序列和便是An任意两数之差（
    // 注意，由于题目要求的是绝对值最小，所以求出A1-A2等效于得出A2-A1），例如：
    //　　A2 - A5 = B2 + B3 + B4 = A2 - A3 + A3 - A4 + A4 - A5 = A2 - A5
    public static int minAbs(int[] A) {
        int[] b = new int[A.length - 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = A[i] - A[i + 1];
        }

        //绝对值最小的最长连续子序列和
        int[] c = new int[b.length];
        int minabs = Integer.MAX_VALUE;
//        for (int i = 0; i <c.length; i++) {
//            for (int j = 0; j <=i ; j++) {
//                c[j] += b[i];
//                minabs = Math.min(Math.abs(minabs), Math.abs(c[j]));
//            }
//        }
        //dp绝对值最小的最长连续子序列和
        minabs=b[0];
        int curmin=Integer.MAX_VALUE;
        for (int i = 1; i <b.length ; i++) {
            curmin = Math.min(Math.abs(curmin + b[i]), Math.abs(b[i]));
            if (curmin < minabs) {
                minabs = curmin;
            }
        }
        return minabs;

        //遍历一遍数据，找出最大值Max和最小值Min，然后把整个数据进行划分，step=(Max-Min)/n.
        // 然后遍历这n个桶，相邻元素的最大值一定是某个桶i中的最大值和桶(i+1)中的最小值的差值。具体如何证明可以自己想想一下。
        //
        //(
        //
        //假如这个相邻元素的最大间距不是某个桶i中的最大值和桶(i+1)中的最小值的差值，
        // 即最大间距的两个元素位于同一个桶中，即最大间距小于step，所以Min+n*step<Maxd的。
        // 因此矛盾。所以最大元素肯定是位于不同桶中的。
    }

    public static void main(String[] args) {
        int[] A = new int[] { 2, 1, -4,1};
        System.out.println(minAbs(A));
    }
}
