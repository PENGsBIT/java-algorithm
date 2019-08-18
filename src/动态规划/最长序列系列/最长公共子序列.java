package 动态规划.最长序列系列;

public class 最长公共子序列 {
    public static void main(String[] args) {
        String s="asdfa";
        String s1="rasdaswer";
        System.out.println(dpLCS(s,s1));
    }
    public static int dpLCS(String str1, String str2) {
        if(str1.isEmpty()||str2.isEmpty()) return 0;
        int m=str1.length(), n=str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int DGLCS(String str1,String str2){
        return dgLCS(str1,str1.length()-1,str2,str2.length()-1,0);
    }

    private int dgLCS(String str1, int index1, String str2, int index2,int count){
        if(index1<0||index2<0) return count;
        if(str1.charAt(index1)==str2.charAt(index2)){
            count++;
            return dgLCS(str1,index1-1,str2,index2-1,count);
        }else{
            return Math.max(dgLCS(str1,index1-1,str2,index2,count),
                    dgLCS(str1,index1,str2,index2-1,count));
        }
    }
}
