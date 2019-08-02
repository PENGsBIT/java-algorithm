package preSum;

public class MaxSubSum2D {
    public static void main(String[] args) {
        int[][] a = {
            { 0, -2, -7, 0, 1 },
            { 9, 2, -6, 2, -2 },
            { -4, 1, -4, 1, 6 },
            { -1, 8, 0, -2, 9 }
            //1,2,3 row sum 19
        };
        //System.out.println(Arrays.toString(a[0]));
        System.out.println(maxSubSum2D(a));
    }

    //解方法为将这r行按列求和转为一维矩阵再求最大和，这里的一维矩阵其实就是子列和
    //子矩阵的行数为2？我们可以分解为{0,1}行，{1,2}行，{2,3}行求最大和即可
    //以{0,1}行为例子：
    //0, -2, -7, 0, 3
    //9, 2, -6, 2, 5
    //再该范围内再求最大子矩阵其实就是按列求和转为一维数组再求最大：
    //9,0,-13,2,8

    private static int maxSubSum2D(int[][] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
        int n=a.length;
        int m=a[0].length;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            int[] temp = new int[m];

            for (int j = i; j <n ; j++) {
                for (int k = 0; k <m ; k++) {
                    if (j == i) {
                        temp[k] = a[i][k];
                    } else {
                        temp[k] += a[j][k];
                    }
                }
                max=Math.max(max, maxSubSum(temp));
            }
        }
        return max;
    }

    public static int maxSubSum2D1(int[][] matrix) {
        int N=matrix.length, M=matrix[0].length;
        int sum = Integer.MIN_VALUE;
        int[][] totalColSum = new int[N][M];// 所有子列的和
        int[] subColSum = new int[M];//子列的和
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0)
                    totalColSum[i][j] = matrix[i][j];
                else
                    totalColSum[i][j] = totalColSum[i - 1][j] + matrix[i][j];
            }
        }

        for (int r = 0; r < N; r++) {
            for (int k = r; k < N; k++) {
                //构建子列
                for (int j = 0; j < M; j++) {
                    if (r == k) {
                        subColSum[j] = matrix[r][j];//是求单行的情况
                    } else
//                        if (r == 0) {
//                        subColSum[j] = totalColSum[k][j];//以0为起始行
//                    }
                    // else
                    {
                        subColSum[j] = totalColSum[k][j] - totalColSum[r][j];//以非0为起始行，需要减去前面的
                    }

                }

                sum = Math.max(sum, maxSubSum(subColSum));//转为最大子段和

            }
        }

        return sum;

    }

    //最大子序列
    public static int maxSubSum(int[] a) {
        if (a.length == 0 || a == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE, curSum = 0;
//        for (int i = 0; i < a.length; i++) {
//            curSum = Math.max(curSum + a[i], a[i]);
//            maxSum = Math.max(maxSum, curSum);
//        }
        for (int num : a) {
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
