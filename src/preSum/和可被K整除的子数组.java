package preSum;

import java.util.HashMap;
import java.util.Map;

public class 和可被K整除的子数组 {
    public static void main(String[] args) {
        int[]a={4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(a,5));
    }
    public static int subarraysDivByK(int[] A, int K) {
        int[] sum=new int[A.length+1];
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<sum.length;i++){
            sum[i]=(sum[i-1]+A[i-1])%K;
            if(sum[i]<0)
                sum[i]+=K;
            if(sum[i]==0)
                count++;
            if(map.containsKey(sum[i])){
                count+=map.get(sum[i]);
                map.put(sum[i],map.get(sum[i])+1);
            }else
                map.put(sum[i],1);
        }
        return count;
    }
}
