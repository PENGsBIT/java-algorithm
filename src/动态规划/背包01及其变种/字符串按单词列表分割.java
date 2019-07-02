package 动态规划.背包01及其变种;

import java.util.Arrays;
import java.util.List;

public class 字符串按单词列表分割 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList(new String[]{"let", "code"});
        System.out.println(wordBreak("leetcode",list));
    }
    public static boolean wordBreak(String s, List<String> worddict){
        int len=s.length();
        boolean [] dp=new boolean[len+1];
        dp[0]=true;
        //实质是一种完全背包问题dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
        // 该问题涉及到字典中单词的使用顺序，因此可理解为涉及顺序的完全背包问题。
        //我们用j把[0, i)范围内的子串分为了两部分，[0, j) 和 [j, i)，其中范围 [0, j) 就是dp[j]，
        // 范围 [j, i) 就是s.substr(j, i-j)，其中dp[j]是之前的状态，我们已经算出来了，
        // 可以直接取，只需要在字典中查找s.substr(j, i-j)是否存在了，
        // 如果二者均为true，将dp[i]赋为true，并且break掉，此时就不需要再用j去分[0, i)范围了，因为[0, i)范围已经可以拆分了。最终我们返回dp数组的最后一个值，就是整个数组是否可以拆分的布尔值了，
        for (int i = 1; i <=len ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(dp[j]&&worddict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[len];
    }
}
