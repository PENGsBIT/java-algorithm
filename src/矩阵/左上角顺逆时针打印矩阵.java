package 矩阵;

public class 左上角顺逆时针打印矩阵 {
    public static void main(String[] args) {

        int[][] martix = {
                {9, 8, 7, 6},
                {10, 11, 12, 5},
                {1, 2, 3, 4}
        };
        int cols = martix[0].length, rows = martix.length;
        if (martix == null || cols <= 0 || rows <= 0) {
            return;
        }
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            //shun(martix, cols, rows, start);
            ni(martix, cols, rows, start);
            ++start;
        }
    }

    public static void shun(int[][] martix, int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右打印一行
        for (int i = start; i <= endX; ++i) {
            int number = martix[start][i];
            System.out.println(number);
        }

        // 从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = martix[i][endX];
                System.out.println(number);
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = martix[endY][i];
                System.out.println(number);
            }
        }

        // 从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = martix[i][start];
                System.out.println(number);
            }
        }
    }

    public static void ni(int a[][],int cols,int rows,int index){
        int endX=cols-1-index;
        int endY=rows-1-index;

        for(int i=index;i<=endY;i++){
            System.out.println(a[i][index]);
        }

        if(endX>index){
            for(int i=index+1;i<=endX;i++){
                System.out.println(a[endY][i]);
            }
        }
        if(endX>index&&endY>index){
            for(int i=endY-1;i>=index;i--){
                System.out.println(a[i][endX]);
            }
        }
        if(endX>index&&endY>index+1){
            for(int i=endX-1;i>=index+1;i--){
                System.out.println(a[index][i]);
            }
        }
    }
}
