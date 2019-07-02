public class 字符串相乘 {
    public static void main(String[] args) {
        //System.out.println(Arrays.stream(a).max().getAsInt());
        String a = "691";
        String b = "711";
        System.out.println(multiply(a, b));

    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[num1.length() + num2.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int bit = num1.charAt(i) - '0', carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                carry += bit * (num2.charAt(j) - '0');
                result[i + j + 1] += carry % 10;
                carry /= 10;
            }
            if (carry != 0) result[i] = carry;
        }
        int i = result.length - 1, carry = 0;
        while (i >= 0) {
            carry += result[i--];
            sb.append(carry % 10);
            carry /= 10;
        }
        String res = sb.reverse().toString();
        return res.charAt(0) == '0' ? res.substring(1) : res;
    }
}
