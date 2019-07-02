package K;

public class 第K个 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1,-2,3,10,14,-1,16,3};
        int ans = solve(a, 1);
        System.out.println("ans: " + ans);
    }

    private static int solve(int[] a, int k) {
        int l = 0;
        int r = a.length - 1;
        int index = 0;
        while (index < k) {
            index = partiton(a, l, r);
            if (index < k) {
                l = index + 1;
            } else if (index > k) {
                r = index - 1;
            }
        }
        return a[index-1];
    }

    private static int partiton(int[] a, int l, int r) {
//        if (l < r) {
//            int i = l;
//            int j = r;
//            int temp = a[i];
//            while (i < j) {
//                while (i < j && a[j] >= temp) {
//                    j--;
//                }
//                a[i] = a[j];
//                while (i < j && a[i] <= temp) {
//                    i++;
//                }
//                a[j] = a[i];
//            }
//            a[i] = temp;
//            return i;
//        }
//        return -1;
        int i = l, j = r + 1;
        while (true) {
            while (a[++i] < a[l] && i < r) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }
    public static void swap(int[]a,int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}


