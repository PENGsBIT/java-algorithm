package 数学;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-01 22:33
 **/

public class 大数相加 {
    public static void main(String[] args) {
        System.out.println(bigSum("64","36"));;
    }
    public static String bigSum(String num1, String num2){
        if (num1 == null || "".equals(num1)||num2 == null || "".equals(num2)) {
            return "";
        }
        if (num1.length()<num2.length()){
            return bigSum(num2,num1);
        }
        StringBuffer result = new StringBuffer();
        StringBuffer sb=new StringBuffer();
        num1=sb.append(num1).reverse().toString();
        sb.delete(0,sb.length());
        num2=sb.append(num2).reverse().toString();
        int carry=0;
        for (int i = 0; i <num2.length(); i++) {
            int temp=num1.charAt(i)-'0'+num2.charAt(i)-'0'+carry;
            carry=temp/10;
            int cur =temp%10;
            result.append(cur);
        }
        if (carry!=0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
