package 矩阵;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 14:50
 **/

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zpc
 * @Description: leetcode149. 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * @Create: 2019-09-24 14:50
 **/


public class 直线上最多的点数 {
    public int maxPoints(Point[] points) {
        /*
        遍历每个点，看它和后面的每个点构成的直线上有多少个点
        对每个点建立map，斜率是key
        斜率要用分数的形式，不要用double的形式存
        计算分数时先求分子分母的最大公约数gcd，再都除以gcd
        重合的点特殊处理
        */
        int l = points.length;
        if (l == 0) return 0;
        if (l <= 2) return l;
        int res = 0;
        for (int i = 0; i < l - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0;
            int lineMax = 0;
            for (int j = i + 1; j < l; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                // 用string来存储斜率
                String slope = String.valueOf(x) + String.valueOf(y);
                int count = map.getOrDefault(slope, 0);
                count++;
                map.put(slope, count);
                lineMax = Math.max(lineMax, count);
            }
            res = Math.max(res, lineMax + overlap + 1);
        }
        return res;
    }

    public int generateGcd(int x, int y) {
        if (y == 0) return x;
        return generateGcd(y, x % y);
    }
}
