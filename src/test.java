import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//24
public class test {
    public static void main(String[] args) {
        for (int j = 0; j <10 ; j++) {
            Random r1=new Random();
            ArrayList<Integer> list1=new ArrayList<>();
            for (int i = 1; i <=20; i++) {
                list1.add(r1.nextInt(i));
            }
            System.out.println(qselect(list1,10 ));
        }

    }


    public static List<Integer> qselect(List<Integer> nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.size() < k) {
            return nums;
        }
        Random random = new Random();
        int index = random.nextInt(nums.size() - 1);
//        index = nums.size() - 1;
        List<Integer> rest = new ArrayList<>();
        for (int num : nums) {
            if (num >= nums.get(index)) {
                list.add(num);
            } else {
                rest.add(num);
            }
        }
        if (list.size() == k) {
            return list;
        } else if (list.size() > k) {
            return qselect(list, k);
        } else {
            rest = qselect(rest, k-list.size());
            list.addAll(rest);
            return list;
        }
    }
}



