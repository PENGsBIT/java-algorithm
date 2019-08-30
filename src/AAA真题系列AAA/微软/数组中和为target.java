package AAA真题系列AAA.微软;

import java.util.HashMap;

public class 数组中和为target {
    public static void main(String[] args) {
        int[] numbers={3,6,5,7,4};
        System.out.println(twoSum2(numbers,10));
    }
    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers != null) {
            // 因为Hashmap仅提供通过key获得value,故
            // HashMap value放置与numers[index]匹配的数值,key放置index；，故
            // 在下面循环时每一次查询map中的value是否有相等的值，有即相互匹配
            // 其思想在于用index的value表示数组中的该数据，map中的key与之匹配，并在数组中寻找匹配值
            HashMap<Integer, Integer> num_map = new HashMap<Integer, Integer>();
            for (int i = 0; i < numbers.length; i++) {
                if (num_map.containsKey(numbers[i])) {
                    int index = num_map.get(numbers[i]);
                    int[] result = { ++index, ++i };
                    return result;
                } else {
                    num_map.put(target - numbers[i], i);
                }
            }
        }
        return null;
    }
}
