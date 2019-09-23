package AAA真题系列AAA.微软;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-17 16:16
 **/

import java.util.*;

/**
 * @Author: zpc
 * @Description:
 *
 * 三个转盘（A-Z），处于某一个状态start，比如MSF。
 * 求出将start转到另一个状态target所要转动转盘而形成的字符串序列。比如MSF->OFC：[MSF,NSF,OSF,OSE,...,OFC。
 * 此外，有另一个参数BlockList，是个字符串列表，输出的序列不能包含BlockList中的字符串，即转动时不能经过这些状态。
 * @Create: 2019-09-17 16:16
 **/


public class 单词接龙block版 {

        private static String source = "ABC";
        private static String target = "ACD";
        private static String[] blocks = {"ACC", "ABD"};
        private static Set<String> blocked = new HashSet<>(Arrays.asList(blocks));
        private static Set<String> visited = new HashSet<>();
        //使用队列保存字符串的演化
        private static String[] queue = new String[(int) Math.pow(26, source.length()) + 10];
        //pre记录字符串由哪个演化而来
        private static int[] pre = new int[queue.length];

        private static int head, tail;

        public static void main(String[] args) {
            BFS();
            List<String> path = new ArrayList<>();
            for (; tail != -1; tail = pre[tail]) {
                path.add(queue[tail]);
            }
            Collections.reverse(path);
            System.out.println(String.join(" -> ", path));
        }

        private static void BFS() {
            head = 0;
            tail = 1;
            queue[0] = source;
            pre[0] = -1;
            //visited记录访问过的string
            visited.add(source);

            while (head < tail) {
                String current = queue[head];
                for (int i = 0; i < source.length(); i++) {
                    String[] nextStrings = {forward(current, i), backward(current, i)};
                    for (String next: nextStrings) {
                        if (!visited.contains(next) && !blocked.contains(next)) {
                            visited.add(next);
                            queue[tail] = next;
                            pre[tail] = head;
                            if (next.equals(target)) {
                                return;
                            }
                            tail++;
                        }
                    }
                }
                head++;
            }
        }

        private static String forward(String s, int k) {
            char c = (char) (s.charAt(k) + 1);
            c = c > 'Z' ? 'A' : c;
            return s.substring(0, k) + c + s.substring(k + 1);
        }

        private static String backward(String s, int k) {
            char c = (char) (s.charAt(k) - 1);
            c = c < 'A' ? 'Z' : c;
            return s.substring(0, k) + c + s.substring(k + 1);
        }

}
