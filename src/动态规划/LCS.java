package 动态规划;

public class LCS {
    /**
     * 获取两个字符串最长公共子串长度
     * @param str	第一个字符串
     * @param str2	第二个字符串
     * @return	如果存在则返回最长公共子串长度，否则返回0
     */
    /**
     * 获取两个字符串最长公共子串长度
     * @param str	第一个字符串
     * @param str2	第二个字符串
     * @return	如果存在则返回最长公共子串长度，否则返回0
     */
    public static int getLCSLength2(String str, String str2){
        char[] ary = str.toCharArray();
        char[] ary2 = str2.toCharArray();

        int[][] temp = new int[ary.length][ary2.length];	//声明一个二维数组，存储最长公共子串长度
        int longestLength = 0;	//最长公共子串长度

        for(int i = 0; i < ary2.length; i++){	//初始化二维矩阵中的第一行
            temp[0][i] = (ary[0] == ary2[i]) ? 1 : 0;
        }

        for(int j = 1; j < ary.length; j++){	//初始化二维矩阵中的第一列
            temp[j][0] = (ary2[0] == ary[j]) ? 1 : 0;
        }

        for (int i = 1; i < ary.length; i++) {
            for (int j = 1; j < ary2.length; j++) {
                if(ary[i] == ary2[j]){
                    temp[i][j] = temp[i-1][j-1] + 1;
                    if(temp[i][j] > longestLength){	//当前元素值大于最大公共子串长度
                        longestLength = temp[i][j];
                    }
                }else{
                    temp[i][j] = 0;
                }
            }
        }
        return longestLength;
    }
    //经典动态规划的方法需要大小为M*N的 dp 矩阵，但实际上是可以减少至O（1）的，因为计算每一个dp[i][j]的时候只需要计算dp[i-1][j-1],所以按照斜线方向计算所有的值，只需要一个变量就可以计算：
    public static void Lcss1(char str1[],char str2[])
    {
        int len=0,max=0;
        int row=0;
        int col=str2.length-1;
        //计算矩阵中的每一条斜对角线上值。
        while(row<str1.length)
        {
            int i=row;
            int j=col;
            while(i<str1.length&&j<str2.length)
            {
                if(str1[i]==str2[j])
                {
                    len++;
                    max=Math.max(max, len);
                }
                else {
                    len=0;
                }
                i++;
                j++;
            }
            if(col>0)
            {
                col--;
            }
            else {
                row++;
            }
        }

        System.out.println(max);
    }


}
