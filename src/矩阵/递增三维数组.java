package 矩阵;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-02 22:28
 **/

public class 递增三维数组 {
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{2,5,3,6,7}));;
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(new LinkedList<Integer>(), 0, nums, res);
        return res;
    }
    private static void dfs(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()==3) res.add(new LinkedList<Integer>(list));
        //if(list.size()>3) res.add(new LinkedList<Integer>(list));
//        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
//            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
//                used.add(nums[i]);
                list.add(nums[i]);
                dfs(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
    }

}
