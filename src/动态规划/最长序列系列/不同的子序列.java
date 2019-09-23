package 动态规划.最长序列系列;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 16:40
 **/

/**
 * @Author: zpc
 * @Description: leetcode115. 不同的子序列
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 示例 1:
 *
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2:
 *
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 *
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * @Create: 2019-09-23 16:40
 **/


public class 不同的子序列 {
    public static int numDistinct(String T, String S) {
        int[][] dp = new int[T.length()+1][S.length()+1];

        //第一行必须填入1。这是因为空字符串是任意字符串的子序列，但只有1次。
        // 所以对于每个j来说mem[0][j] = 1，这样不仅使我们的生活更简单，而且如果T是一个空字符串，我们还返回正确的值。
        for(int j=0; j<=S.length(); j++) {
            dp[0][j] = 1;
        }

        //除第一行外，每一行的第一列必须为0。这是因为空字符串不能包含非空字符串作为子字符串
        // S 0123....j
        //T +----------+
        //  |1111111111|
        //0 |0         |
        //1 |0         |
        //2 |0         |
        //. |0         |
        //. |0         |
        //i |0         |

        // 数组的第一项:dp[0][0] = 1，因为空字符串包含只一个空字符串。
        dp[0][0] = 1;
        for(int i=1; i<=T.length(); i++) {
            for(int j=1; j<=S.length(); j++) {
                //字符串t中的子序列应该以字符t.charAt (j - 1)结尾
                //当s中新的递增字符时，s [i-1]与t [j-1]相等，这包含两种情况：
                if(T.charAt(i-1) == S.charAt(j-1)) {
                    //我们以这种方式匹配这两个字符。dp [i] [j] = dp [i-1] [j-1];
                    //因此，包括这两种情况，dp [i] [j] = dp [i-1] [j] + dp [i-1] [j-1]
                    //以t.charAt (j - 1)结尾作为结尾dp [i] [j] = dp [i] [j-1]
                    //不以t.charAt (j - 1)结尾作为结尾dp [i] [j] =dp[i-1][j-1]
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    //我们不匹配这两个字符，这意味着它仍然具有原始数量的不同子序列，因此dp [i] [j] = dp [i-1] [j]。
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        //一个例子：
        //S: [acdabefbc]和T: [ab]
        //
        //首先我们检查a：
        //
        //           *  *
        //      S = [acdabefbc]
        //mem[1] = [0111222222]
        //然后我们检查ab：
        //
        //               *  * ]
        //      S = [acdabefbc]
        //mem[1] = [0111222222]
        //mem[2] = [0000022244]
        //结果为4，因为不同的子序列是：
        //
        //      S = [a   b    ]
        //      S = [a      b ]
        //      S = [   ab    ]
        //      S = [   a   b ]
        return dp[T.length()][S.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
