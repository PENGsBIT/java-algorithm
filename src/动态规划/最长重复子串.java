package 动态规划;

public class 最长重复子串 {
    public static void main(String[] args) {
        int[] a = {1,3,2,1};
        int[] b = {3,2,1,4,7};
        String s="abcabca";
        System.out.println(maxRepat(s));
    }

    public static String maxRepat(String input) {
        if(input == null || input.length() == 0){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int k = Integer.MIN_VALUE;
        int first = 0;
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if(input.charAt(j) == input.charAt(i + j)){
                    k++;
                }else{
                    k = 0;
                }

                if(k > max){
                    max = k;
                    first = j - k + 1;
                }
            }
        }

        return input.substring(first, first + max);
    }
}
