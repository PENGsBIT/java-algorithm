package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-31 16:56
 **/

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: zpc
 * @Description: leetcode 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *  
 *
 * 示例 1:
 *
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 *
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 *
 * @Create: 2019-08-31 16:56
 **/


public class 比较版本号 {
    public static void main(String[] args) {
        String str="7.5.2.4, 7.5.3";
        String[] versions = str.split(", ");
        Collections.sort(Arrays.asList(versions),(s1, s2)->compareVersion(s1,s2));
        System.out.println(versions[0]);
    }
    private static int compareVersion(String s1,String s2) {
        String[] v1 = s1.split("\\.");
        String[] v2 = s2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i <len ; i++) {
            Integer i1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            Integer i2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (i1.compareTo(i2) != 0) {
                return i1.compareTo(i2);
            }
        }
        return 0;
    }
}
