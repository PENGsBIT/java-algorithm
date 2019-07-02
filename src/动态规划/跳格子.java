package 动态规划;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-06-18 21:47
 **/

public class 跳格子 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        int last=nums.length-1;
        for (int i = last-1; i >=0 ; i--) {
            if(i+nums[i]>=last){
                last=i;
            }
        }
        return last<=0;
    }
}
