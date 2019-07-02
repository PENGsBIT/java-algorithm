package K;

import java.util.*;
import java.util.stream.Collectors;

public class K高频 {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 3;
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        //List<Integer> rs = new ArrayList<>();
        List<Integer> rs = frequencyForNum.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.println(rs);
//        ListIterator iter = rs.listIterator();
//        for (; iter.hasNext(); ) {
//            System.out.println(iter.next().toString());
//        }
//        for (; iter.hasPrevious(); ) {
//            System.out.println(iter.previous() + " ");
//        }
    }
}
