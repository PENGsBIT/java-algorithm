package 转化;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-27 23:09
 **/

/**
 * @Author: zpc
 * @Description: 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，不能申请额外的空间。示例1
 * 输入
 * AkleBiCeilD
 * 输出
 * kleieilABCD
 * @Create: 2019-08-27 23:09
 **/


public class 大小写字符排序 {
    public static void main(String[] args) {
        System.out.println(getResult("AkleBiCeilD"));
        Sort("AkleBiCeilD");
        bubbleSortChar("AkleBiCeilD");
    }

    public static String getResult(String str) {
        System.out.println(str.replaceAll("[A-Z]", ""));
        System.out.println(str.replaceAll("[a-z]", ""));
        return str.replaceAll("[A-Z]", "") + str.replaceAll("[a-z]", "");
    }

    public static void Sort(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                System.out.print(str.charAt(i));
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A')
                System.out.print(str.charAt(i));
    }

    //冒泡排序思想
    public static void bubbleSortChar(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = 0; j < str.length() - 1 - i; j++) {
                if ((chars[j] >= 'A' && chars[j] <= 'Z') && (chars[j + 1] < 'A' || chars[j + 1] > 'Z')) {
                    char c = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = c;
                }
            }
        }
        System.out.println();
        System.out.println(String.valueOf(chars));
    }
}



