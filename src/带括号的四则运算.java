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
        return res;

    }

    public static List<String> calculate(List<String> list, int start, int end) {
        Stack<Float> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            if (list.get(i) == "+" || list.get(i) == "-") {
                stack.push(Float.parseFloat(list.get(i) + list.get(i + 1)));
                i++;
            } else if (list.get(i) == "*") {
                Float f = stack.pop();
                f /= Float.parseFloat(list.get(i));
                stack.push(f);
                i++;
            } else if (list.get(i) == "/") {
                Float f = stack.pop();
                f *= Float.parseFloat(list.get(i));
                stack.push(f);
                i++;
            }
            stack.push(Float.parseFloat(list.get(i)));
        }
        list.set(start, String.valueOf(stack.stream().count()));
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
//定义两个栈S1， S2。我们规定，S1用来存放符号，S2用来存放数字。
// 将表达式遍历一下，遇到数字，压进栈S2中，遇到字符，压进栈S1中，
// 但是我们始终保持S1最多只有一个运算符，多余的话，就把之前的拿出来计算一下。
// 碰到乘法、除法这种优先级高的，就先进行运算，然后将结果入栈S2中。
class StringCaculate {
    private Stack<BigDecimal> numbers = new Stack<BigDecimal>();
    private Stack<Character> chs = new Stack<Character>();

    /**
     *  * 比较当前操作符与栈顶元素操作符优先级，如果比栈顶元素优先级高，则返回true，否则返回false
     *  *
     *  * @param str
     *  *    需要进行比较的字符
     *  * @return 比较结果 true代表比栈顶元素优先级高，false代表比栈顶元素优先级低
     *  
     */


    private boolean compare(char str) {
        if (chs.empty()) {
// 当为空时，显然 当前优先级最低，返回高
            return true;
        }
        char last = (char) chs.lastElement();
        switch (str) {
            case '*': {
                // '*/'优先级只比'+-'高
                if (last == '+' || last == '-')
                    return true;
                else
                    return false;
            }
            case '/': {
                if (last == '+' || last == '-')
                    return true;
                else
                    return false;
            }
            // '+-'为最低，一直返回false
            case '+':
                return false;
            case '-':
                return false;
        }
        return true;
    }


    public BigDecimal caculate(String st) {
        StringBuffer sb = new StringBuffer(st);
        StringBuffer num = new StringBuffer();
        String tem = null;
        char next;
        while (sb.length() > 0) {
            tem = sb.substring(0, 1);// 获取字符串的第一个字符
            sb.delete(0, 1);
            if (isNum(tem.trim())) {
                num.append(tem);// 如果是数字，将其放入num当中
            } else {
                if (num.length() > 0 && !"".equals(num.toString().trim())) {
                    // 当截取的字符不是数字时，则认为num中放置的时一个完整的数字，
                    // 如123+1,当获取到+时，前面的123可以认为是一个完整的数
                    BigDecimal bd = new BigDecimal(num.toString().trim());
                    numbers.push(bd);
                    num.delete(0, num.length());
                }
                // 如果chs为空，这认为这时第一个字符直接放入
                if (!chs.isEmpty()) {
                // 当当前的运算符优先级等于或者小于栈顶得预算符时，做运算.
                // 例如,1+2+3,当截取到2,3之间的“+”与1,2之间的"+"优先级相等时，可以先计算1+2，使其变成3+3
                // 同样，1*2+3,当截取到2,3之间的“+”与1,2之间的"*"优先级小，可以先计算1*2，使其变成2+3
                    while (!compare(tem.charAt(0))) {
                        caculate();
                    }
                }
// 当数字栈也为空时,既运算式的第一个数字为负数时
                if (numbers.isEmpty()) {
                    num.append(tem);
                } else {
                    chs.push(new Character(tem.charAt(0)));
                }
// 判断后一个字符是否为“-”号，为"-"号时，认为数字为负数
// 例如 1*2*(-5)，因为此运算不计算()，因此将被改写为1*2*-5,如此情况，须将"-"认为是负数表达式而非减号
                next = sb.charAt(0);
                if (next == '-') {
                    num.append(next);
                    sb.delete(0, 1);
                }

            }
        }
// 由于前面将数字放入栈时，是通过获取符号为时处理，导致最后一个数字没有放入栈中，因此将最后的数字放入栈中
        BigDecimal bd = new BigDecimal(num.toString().trim());
        numbers.push(bd);
// 此时符号栈上最多只有2个符号，并且栈顶得符号优先级高，做运算
        while (!chs.isEmpty()) {
            caculate();
        }
        return numbers.pop();
    }


    private void caculate() {
        BigDecimal b = numbers.pop();// 第二个运算数
        BigDecimal a = null;// 第一个运算数
        a = numbers.pop();
        char ope = chs.pop();
        BigDecimal result = null;// 运算结果
        switch (ope) {
// 如果是加号或者减号，则
            case '+':
                result = a.add(b);
// 将操作结果放入操作数栈
                numbers.push(result);
                break;
            case '-':
// 将操作结果放入操作数栈
                result = a.subtract(b);
                numbers.push(result);
                break;
            case '*':
                result = a.multiply(b);
// 将操作结果放入操作数栈
                numbers.push(result);
                break;
            case '/':
                result = a.divide(b);// 将操作结果放入操作数栈
                numbers.push(result);
                break;
        }
    }


    private boolean isNum(String num) {
        return num.matches("[0-9]");
    }

    /**
     *  *
     *  * 功能描述。
     *  * 解析，将带有括号的运算符变成没有带括号的字运算
     *  
     */

    public BigDecimal parse(String st) {
        int start = 0;
        StringBuffer sts = new StringBuffer(st);
        int end = -1;
        while ((end = sts.indexOf(")")) > 0) {
            String s = sts.substring(start, end + 1);
            int first = s.lastIndexOf("(");
            BigDecimal value = caculate(sts.substring(first + 1, end));
            sts.replace(first, end + 1, value.toString());
        }
        return caculate(sts.toString());
    }


    public static void main(String[] args) {
        String a = "(5+-2)*1";
        StringCaculate caculate = new StringCaculate();
        System.out.println(caculate.parse(a));
    }
}

