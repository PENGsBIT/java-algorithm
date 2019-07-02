import java.util.ArrayList;
import java.util.List;

public class 二维数组转换成List {


    /**
     * 将二维数组转换成List<List<String>>形式工具
     *
     */


    public static void main(String[] args) {
        String[][] strCe = new String[2][2];
        strCe[0][0] = "1";
        strCe[0][1] = "2";
        strCe[1][0] = "3";
        strCe[1][1] = "4";

        List<List<String>> listTest = new ArrayList<>();
        for (int i = 0; i < strCe.length; i++) {
            List<String> columnList = new ArrayList<>();
            for (int j = 0; j < strCe[i].length; j++) {
                columnList.add(j, strCe[i][j]);
            }
            listTest.add(i, columnList);
        }

        System.out.println(listTest);
        System.out.println(strCe);

    }

}
