package 转化.字符串与数字转化;

//输入：三千二百零一万九千七百六十五亿四千三百二十一万九千八百七十六
//
//输出：3201976543219876
//
//算法思想：由于原串包含的汉字种类较多，那么我们可以把该字符串转为数字字符串，然后数字字符串变为long型整数就简单多了。
public class 中文字符串转为long型整数 {
    public static long parseChineseNumber(String s){
        long  num = 0;
        StringBuilder  sb = new StringBuilder();
        for(int i = 0 ; i< s.length();i++){
            switch(s.charAt(i)){
            case '零': sb.append('0');break;
            case '一': sb.append('1');break;
            case '二': sb.append('2');break;
            case '三': sb.append('3');break;
            case '四': sb.append('4');break;
            case '五': sb.append('5');break;
            case '六': sb.append('6');break;
            case '七': sb.append('7');break;
            case '八': sb.append('8');break;
            case '九': sb.append('9');break;

            }
        }
        System.out.println("****"+sb+"****");
//        long  wei = 1;
//        for(int i = sb.length() -1;i>=0 ;i--){
//            num += (sb.charAt(i)-'0')*wei;
//            System.out.println("num = " + num);
//            wei = wei * 10;
//        }
        num=Long.valueOf(sb.toString());
        return  num ;
    }

    public static void main(String[] args) {
        System.out.println(parseChineseNumber("三千二百零一万九千七百六十五亿四千三百二十一万九千八百七十六"));
    }

}
