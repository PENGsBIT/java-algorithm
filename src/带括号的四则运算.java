import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 带括号的四则运算 {

    public static void main(String[] args) {
        String str = "0.34+3.9*(7 - 2*3.6)/0.66+8-(9.3+8/3)";
//            String str = "0.34+3.9*(7 - 2*3.6)/0.66+8";
        BigDecimal result = cal(str);
        System.out.println(result);
    }

    public static BigDecimal cal(String str) {
        // 对表达式进行预处理，并简单验证是否是正确的表达式
        // 存放处理后的表达式
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        // 存放数字临时变量
//            StringBuffer tmpStr = new StringBuffer();
        String tmpStr = "";
        for (char c : chars) {
            // 如果是数字或小数点，添加到临时变量中
            if (c >= '0' && c <= '9' || c == '.') {
//                    tmpStr.append(c);
                tmpStr += c;
            }
            // 如果是加减乘除或者括号，将数字临时变量和运算符依次放入list中
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                if (tmpStr.length() > 0) {
                    list.add(tmpStr);
                    tmpStr = "";
                }
                list.add(c + "");
            }
        }
        if (tmpStr.length() > 0) {
            list.add(tmpStr);
        }
//        int lk = list.lastIndexOf("(");
//        int rk = list.indexOf(")");
//        while (lk>=0){
//            list=calculate(list,lk+1,rk-1);
//            int t=lk++;
//            while (t<=rk){
//                list.remove(t);
//            }
//            lk = list.lastIndexOf("(");
//            rk = list.indexOf(")");
//        }
//        calculate(list,0,list.size()-1);

       List<String> strList = pre2back(list);
       BigDecimal res = calback(strList);
        return res ;

    }

    public static List<String> calculate(List<String> list, int start, int end) {
        Stack<Float> stack=new Stack<>();
        for (int i = start; i <end ; i++) {
            if(list.get(i)=="+"||list.get(i)=="-"){
                stack.push(Float.parseFloat(list.get(i)+list.get(i+1)));
                        i++;
            }else if(list.get(i)=="*"){
                Float f=stack.pop();
                f/=Float.parseFloat(list.get(i));
                stack.push(f);
                        i++;
            }else if(list.get(i)=="/"){
                Float f=stack.pop();
                f*=Float.parseFloat(list.get(i));
                stack.push(f);
                        i++;
            }
           stack.push(Float.parseFloat(list.get(i)));
        }
        list.set(start,String.valueOf(stack.stream().count()));
        return list;
    }


    private static List<String> pre2back(List<String> list) {
        // 初始化后缀表达式
        List<String> strList = new ArrayList<>();
        // 运算过程中，使用了两次栈结构，第一次是将中缀表达式转换为后缀表达式，第二次是计算后缀表达式的值
        Stack<String> stack = new Stack<>();
        // 声明临时变量，存放出栈元素
        String tmp;
        // 1. 将中缀表达式转换为后缀表达式
        for (String s : list) {
            // 如果是左括号直接入栈
            if (s.equals("(")) {
                stack.push(s);
            }
            // 如果是右括号，执行出栈操作，依次添加到后缀表达式中，直到出栈元素为左括号，左括号和右括号都不添加到后缀表达式中
            else if (s.equals(")")) {
                while (!(tmp = stack.pop()).equals("(")) {
                    strList.add(tmp);
                }
            }
            // 如果是加减乘除，弹出所有优先级大于或者等于该运算符的栈顶元素（栈中肯定没有右括号，认为左括号的优先级最低），然后将该运算符入栈
            else if (s.equals("*") || s.equals("/")) {
                while (!stack.isEmpty()) {
                    // 取出栈顶元素
                    tmp = stack.peek();
                    if (tmp.equals("*") || tmp.equals("/")) {
                        stack.pop();
                        strList.add(tmp);
                    } else {
                        break;
                    }
                }
                stack.push(s);
            } else if (s.equals("+") || s.equals("-")) {
                while (!stack.isEmpty()) {
                    // 取出栈顶元素
                    tmp = stack.peek();
                    if (!tmp.equals("(")) {
                        stack.pop();
                        strList.add(tmp);
                    } else {
                        break;
                    }
                }
                stack.push(s);
            }
            // 如果是数字，直接添加到后缀表达式中
            else {
                strList.add(s);
            }
        }
        // 最后依次出栈，放入后缀表达式中
        while (!stack.isEmpty()) {
            strList.add(stack.pop());
        }
        return strList;
    }

    private static BigDecimal calback(List<String> strList) {
        // 2.计算后缀表达式的值
        Stack<BigDecimal> newStack = new Stack<>();
        for (String s : strList) {
            // 若遇运算符，则从栈中退出两个元素，先退出的放到运算符的右边，后退出的放到运算符左边，
            // 运算后的结果再进栈，直到后缀表达式遍历完毕
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                BigDecimal b1 = newStack.pop();
                BigDecimal b2 = newStack.pop();
                switch (s) {
                    case "+":
                        newStack.push(b2.add(b1));
                        break;
                    case "-":
                        newStack.push(b2.subtract(b1));
                        break;
                    case "*":
                        newStack.push(b2.multiply(b1));
                        break;
                    case "/":
                        newStack.push(b2.divide(b1, 9, BigDecimal.ROUND_HALF_UP));
                        break;
                }
            }
            // 如果是数字，入栈
            else {
                newStack.push(new BigDecimal(s));
            }
        }
        // 最后，栈中仅有一个元素，就是计算结果
        return newStack.peek();

    }

}
