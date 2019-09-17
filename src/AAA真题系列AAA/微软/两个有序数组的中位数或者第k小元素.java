package AAA真题系列AAA.微软;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-09 23:11
 **/

public class 两个有序数组的中位数或者第k小元素 {
    //两个排序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //让我们在任一位置  将 A 划分成两个部分,采用同样的方式，我们在任一位置 [公式] 将 B 划分成两个部分：
//        将 left_A 和 left_B 放入一个集合，并将 right_A 和 right_B 放入另一个集合。 再把这两个新的集合分别命名为 left_part 和 right_part：
//        我们已经将 {A,B} 中的所有元素划分为相同长度的两个部分，且其中一部分中的元素总是大于另一部分中的元素。
//        1、len(left_part)==len(right_part)2、max(left_part)<=min(right_part)
// 那么：median==(max(left)+min(right))/2
        int n1Length = nums1.length;
        int n2Length = nums2.length;
        if(nums1.length > nums2.length){
            int[]temp=nums1;
            nums1 = nums2;
            nums2 = temp;
//            return findMedianSortedArrays(nums2, nums1);
        }
        // nums1 should be smaller array.
        int left = 0;
        int right = nums1.length;
        double res = 0;
        while(left <= right){
            //i + j == m - i + n - j (or: m - i + n - j + 1)
            //也就是保证mid1 + mid2 == n1Length - mid1 + n2Length - mid2
            // (or: n1Length - mid1 + n2Length - mid2 + 1)
            int mid1 = (left+right)/2;
            //如果m + n是偶数，则将元素均匀地分成左右两部分，所以i + j = m + n - i - j。
            // （显然，第一个中间数字在左侧部分第二个中间数字在右侧部分）=>因此j = (m + n)/2 - i
            //如果m + n是奇数，然后将中位数放在左边部分，因此左边部分的元素数量比右边部分的元素数量多一个。
            // 这就是+ 1公式中的位置：i + j = m + n - i - j + 1=>因此j = (m + n + 1)/2 - i
            //num是偶数，那么num/2 = (num + 1)/2，例如4/2 = (4 + 1)/2 = 2。所以(m + n)/2等于(m + n + 1)/2（1）。
            // 因此我们可以将它们合并到（2）。这就是我们j = (m + n + 1)/2 - i通过代码使用的原因。
            int mid2 = (n1Length + n2Length + 1)/2 - mid1 ;

            int n1Left = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int n1Right = mid1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1];

            int n2Left = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int n2Right = mid2 == nums2.length ? Integer.MAX_VALUE : nums2[mid2];

            // Now compare.max(left_part)<=min(right_part)
            if(n1Left <= n2Right && n2Left <= n1Right) {
                if((n1Length+n2Length) % 2 == 0) {
                    res=(Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2.0;
                }else {
                    res= (double)Math.max(n1Left, n2Left);
                }
                break;
            }
            else if(n1Left > n2Right) right = mid1 - 1;
            else left = mid1 + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        //定义两个有序数组a,b
        int[] a = new int[]{1,9,10,18};
        int[] b = new int[]{7,10};
        System.out.println("中位数："+findMedianSortedArrays(a,b));
        //查找两个数组的中位数
        int mark = (a.length + b.length)%2;
        int mid = (a.length + b.length)/2;
        if(mark != 0){
            System.out.println(Search(a,0,a.length-1,b,0,b.length-1,mid));
        }else{
            int p = Search(a,0,a.length-1,b,0,b.length-1,mid);
            int q = Search(a,0,a.length-1,b,0,b.length-1,mid+1);
            System.out.println("中位数："+(double)(p+q)/2);
        }

        //查找两个数组的第k小元素
        int k = 6;
        System.out.println("k位数："+Search(a,0,a.length-1,b,0,b.length-1,k));


    }

    public static int Search(int[] a,int startA,int endA,int[] b,int startB,int endB,int k){
        if(k == 1){
            if(a[startA] <= b[startB]){
                return a[startA];
            }else{
                return b[startB];
            }
        }

        //如果startA>endA,则说明A中的元素已经排除完，只剩下B中元素，此时只要取B中前k个元素就好
        if(startA > endA){
            return b[startB + k - 1];
        }
        //同上
        if(startB > endB){
            return a[startA + k -1];
        }

        int al = endA - startA + 1;
        int bl = endB - startB + 1;

        //如果a中元素个数大于b中元素个数，此时应该将a与b的位置交换，将元素少的数组放在前面，这是为了57行代码的判断
        if(al > bl){
            return Search(b,startB,endB,a,startA,endB,k);
        }

        int ms = 0;
        int ns = 0;

        //如果a中元素个数<k/2,此时应该取a中的所有元素,如果不做49的行的处理的话，可能会造成数组溢出
        if((endA - startA + 1) < k/2){
            ms = endA - startA + 1;
        }else{
            ms = k/2;
        }

        ns = k - ms ;

        int m = ms-1 + startA;
        int n = ns-1+ startB;

//      System.out.println(m);
//      System.out.println(n);

        if(a[m] == b[n]){
            return a[m];
        }else if(a[m] > b[n]){
            return Search(a,startA,m,b,n+1,endB,k-ns);
        }else{
            return Search(a,m+1,endA,b,startB,n,k-ms);
        }


    }


}


