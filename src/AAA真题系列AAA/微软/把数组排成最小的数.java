package AAA真题系列AAA.微软;

import java.util.Arrays;

//剑指offer:把数组排成最小的数
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
public class 把数组排成最小的数 {
    public static String PrintMinNumber(Integer [] numbers) {
        Arrays.sort(numbers,(o1,o2)->(o1+""+o2).compareTo((o2+""+o1)));
        String res = "";
        for (Integer number : numbers) {
            res += number + "";
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new Integer[]{3,32,321}));
    }
}
