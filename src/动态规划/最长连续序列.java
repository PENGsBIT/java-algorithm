package 动态规划;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[]nums={0,0,-1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <nums.length ; i++) {
            if(islowbound(set,nums[i])){
                continue;
            }else {
                int count=1;
                int temp=nums[i]+1;
                while (set.contains(temp)){
                    count++;
                    temp++;
                }
                max=max>count?max:count;
            }
        }
        return max;
    }

   private static boolean islowbound(Set<Integer> set,int a){
        return set.contains(a-1);
   }
}
