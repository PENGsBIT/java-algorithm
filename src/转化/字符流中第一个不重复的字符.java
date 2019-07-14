package 转化;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 10:46
 **/

public class 字符流中第一个不重复的字符 {
    //-128
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
