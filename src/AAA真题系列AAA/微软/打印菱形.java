package AAA真题系列AAA.微软; /**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-18 15:12
 **/

/**
 * @Author: zpc
 * @Description:
 * @Create: 2019-09-18 15:12
 **/


public class 打印菱形 {
    public static void printRhombus(int height){
        //菱形中间那层的数量为height
        for (int i = 0; i < height; i++) {//行     9是菱形的高度
            for (int j = 0; j < Math.abs(height/2-i); j++) {//空格   Math.abs绝对值
                System.out.print(" ");
            }
            //每少一层少两个
            for (int j = 0; j < height - 2 * Math.abs(i - height/2); j++) {//打印星星
                System.out.print("*");
            }
            System.out.println();//换行
        }
    }

    public static void main(String[] args) {
        printRhombus(3);
    }
}
