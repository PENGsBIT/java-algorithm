package 贪心;

import java.util.Arrays;

public class 无重叠区间 {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,3);
        intervals[1] = new Interval(3,22);
        intervals[2] = new Interval(1,2);
        intervals[3] = new Interval(2,3);
//        intervals[0] = new Interval(1,12);
//        intervals[1] = new Interval(12,13);
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, ((o1, o2) -> o1.end==o2.end?o2.start-o1.start:o1.end-o2.end));
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }
        return intervals.length - res;
    }
}
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
