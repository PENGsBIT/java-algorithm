package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-29 20:10
 **/

import java.util.*;

/**
 * @Author: zpc
 * @Description: taptap
 * @Create: 2019-08-29 20:10
 **/

//  给定一些字符串只含有a-z，我们想对它们重新排序，但是我们重新定义字典序，这个字典序是由一个a-z的排列给出，输出按新的字典从小到大排序好的字符串列表。
//abcdefghijklmnopqrstuvwxyz
//3
//cba
//def
//abc
//结果
//abc
//cba
//def
    //zyxwvutsrqponmlkjihgfedcba
//3
//aaa
//bbb
//ccc
    //ccc
//bbb
//aaa
public class 自定义字典序 {
    public static void main(String[] args)  {
        Scanner sca = new Scanner(System.in);
        String dict = sca.nextLine();
        int n = sca.nextInt();
        List<String> res = new ArrayList<>();
        String[] strs = new String[n];
        for (int i = 0; i <n ; i++) {
            strs[i]= sca.next();;
        }
        res = dictSort(dict, strs);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static List<String> dictSort(String dict, String[] strs) {
        List<String> res= Arrays.asList(strs);
        Comparator<String> cmp=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compute(dict,o1,o2);
            }
        };
        Collections.sort(res,cmp);
        return res;
    }

    private static int compute(String dict,String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (dict.indexOf(s1.substring(i, i + 1)) < dict.indexOf(s2.substring(j, j + 1))) {
                return -1;
            } else if (dict.indexOf(s1.substring(i, i + 1)) > dict.indexOf(s2.substring(j, j + 1))) {
                return 1;
            } else {
                i++;
                j++;
                continue;
            }
        }
        if (i < s1.length()) {
            return 1;
        }
        if (j < s1.length()) {
            return -1;
        }
        return 0;
    }

}
