package 转化;

import java.util.ArrayList;
import java.util.List;

public class 单词拆分 {
    public static void main(String[] args) {
        int []a={1,4,5,3,6};
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        //System.out.println(Arrays.stream(a).max().getAsInt());
        System.out.println(wordBreak("leetcodeleet",wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
