package 全排列;

import java.util.*;

public class 字符串全排列 {
    private static TreeSet<String> res = new TreeSet<>(((o1, o2) -> o1.compareTo(o2)));
    public static void main(String[] args) {
        String s = "caab";
        //System.out.println(Permutation(s));
        permute(s.toCharArray(), 0, res);
        System.out.println(res.toString());
    }

    public static void permute(char[] a, int i, TreeSet<String> res) {
        if(a==null || i<0 || i>a.length){
            return;
        }
        if (i == a.length - 1) {
            res.add(String.valueOf(a));
        } else {
            for (int j = i; j < a.length; j++) {
                swap(a, i, j);       //交换前缀,使之产生下一个前缀
                permute(a, i + 1, res);
                swap(a, i, j);       //将前缀换回来,继续做上一个的前缀排列
            }
        }
    }
    private void permute(char[] chars, int curChar, int end) {
        if (chars.length == 0) {
            throw new IllegalArgumentException(this.getClass().getName());
        }
        if (curChar == end) {
            res.add(String.valueOf(chars));
        } else {
            for (int i = curChar; i < chars.length; i++) {
                swap(chars, curChar, i);
                permute(chars, curChar + 1, end);
                swap(chars, curChar, i);
            }
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private static void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<Character>();
            for (int j = i; j < chars.length; ++j) {
                if (!charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }

    private static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }


}
