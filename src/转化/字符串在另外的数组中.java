package 转化;

import java.util.Arrays;

public class 字符串在另外的数组中 {
    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1)
            .filter(str -> Arrays.stream(array2).anyMatch(s -> s.contains(str)))
            .distinct().sorted().toArray(String[]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(inArray(new String[]{"fa","pa"}, new String[]{"fa","qap","tt"})));

    }
}
