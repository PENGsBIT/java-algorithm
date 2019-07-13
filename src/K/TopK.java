package K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TopK {
    public static void main(String[] args) throws Exception {
        // System.out.println(maxProfit(new int[]{1,2,3,0,2}));
        Integer[]a={1, 3, 3, 2, 4, 6};
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(qselect(nums, 2));
    }

    public static List<Integer> qselect(List<Integer> nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.size() < k) {
            return nums;
        }
        Random random = new Random();
        int index = random.nextInt(nums.size() - 1);
//        index = nums.size() - 1;
        List<Integer> left = new ArrayList<>();
        for (int num : nums) {
            if (num >= nums.get(index)) {
                list.add(num);
            } else {
                left.add(num);
            }
        }
        if (list.size() == k) {
            return list;
        } else if (list.size() > k) {
            return qselect(list, k);
        } else {
            left = qselect(left, k-list.size());
            list.addAll(left);
            return list;
        }
    }


}
