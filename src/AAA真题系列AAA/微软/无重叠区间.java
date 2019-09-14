package AAA真题系列AAA.微软;

import java.util.Arrays;
//leetcode 435. 无重叠区间
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
//注意:
//
//可以认为区间的终点总是大于它的起点。
//区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//示例 1:
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//示例 2:
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//示例 3:
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
public class 无重叠区间 {

        //贪心策略应该是每次选取结束时间最早的活动。
        // 直观上也很好理解，按这种方法选择相容活动为未安排活动留下尽可能多的时间。
        // 这也是把各项活动按照结束时间单调递增排序的原因
    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, ((o1, o2) -> o1.end==o2.end?o2.start-o1.start:o1.end-o2.end));
        int res = 1;
        int pre = 0;
        //找出非重叠区间的最大数目
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,3);
        intervals[1] = new Interval(3,22);
        intervals[2] = new Interval(1,2);
        intervals[3] = new Interval(2,3);
//        Interval[] intervals = new Interval[2];
//        intervals[0] = new Interval(1,12);
//        intervals[1] = new Interval(12,13);
        System.out.println(eraseOverlapIntervals(intervals));
    }
}

class Interval {
    int start;
    int end;


    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
