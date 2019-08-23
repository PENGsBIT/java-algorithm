package 转化;

//leetcode 179. 最大数
//

//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
//
//示例 1:
//
//输入: [10,2]
//输出: 210

import java.util.Arrays;
import java.util.Comparator;

//示例 2:
//
//输入: [3,30,34,5,9]
//输出: 9534330
public class 数值数组按一定顺序拼接结果最大 {
    public static String largestNumber(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (s1,s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }

    public static String largestNumber1(int[] num) {
        if(num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for(int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };

        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
        System.out.println(largestNumber1(new int[] { 3, 30, 34, 5, 9 }));
    }
}
