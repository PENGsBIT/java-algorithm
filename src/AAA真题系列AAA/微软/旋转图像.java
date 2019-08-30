package AAA真题系列AAA.微软;

import java.util.Arrays;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-06-26 22:54
 **/

public class 旋转图像 {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}

                };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix) {
        if(matrix.length<=0){
            return;
        }
        int n = matrix.length;
        int half = n / 2;
        //swap
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < n; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=temp;

            }
        }
        System.out.println(Arrays.deepToString(matrix));
        //duichen
        for (int i = 0; i <n; i++) {
            for (int j = i; j <n ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }



}
