package AAA真题系列AAA;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-07 20:11
 **/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zpc
 * @Description:
 * 1个用例8个节点序号0-7，三个数节点的值val,左子树的序号，右子树的序号
 * 1
 * 8
 * 2 -1 -1
 * 1 5 3
 * 4 -1 6
 * 2 -1 -1
 * 3 0 2
 * 2 4 7
 * 7 -1 -1
 * 2 -1 -1
 * @Create: 2019-09-07 20:11
 **/


public class 网易2递增的树 {


    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int T = sca.nextInt();
        List<String> res = new ArrayList<>();
        while (T-- > 0) {
            int N = sca.nextInt();
            Node[] nodes = new Node[N];
            int[] left = new int[N];
            int[] right = new int[N];
            for (int i = 0; i < N; i++) {
                int val = sca.nextInt();
                Node temp = new Node(i, val);
                left[i] = sca.nextInt();
                right[i] = sca.nextInt();
                nodes[i] = temp;
            }
            for (int i = 0; i < N; i++) {
                int l = left[i];
                if (l == -1) {
                    continue;
                } else {
                    Node tl = nodes[l];
                    nodes[i].l = tl;
                }
            }
            for (int i = 0; i < N; i++) {
                int r = right[i];
                if (r == -1) {
                    continue;
                } else {
                    Node tr = nodes[r];
                    nodes[i].r = tr;
                }
            }
            Node root = null;
            loop:
            for (int i = 0; i < N; i++) {
                root = nodes[i];
                int j = 0;
                while (j < N) {
                    if (left[j] == i || right[j] == i) {
                        continue loop;
                    }
                    j++;
                }
                if (j == N) {
                    break;
                }
            }
            //System.out.println(root);
            if (isIncreaseTree(root)) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static boolean isIncreaseTree(Node root) {
        LinkedList<Node> cur = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();
        int thisl = 0;
        int nextl = 0;
        cur.add(root);
        while (!cur.isEmpty()) {
            Node curNode = cur.poll();
            thisl += curNode.val;
            if (curNode.l != null) {
                nextl += curNode.l.val;
                next.add(curNode.l);
            }
            if (curNode.r != null) {
                nextl += curNode.r.val;
                next.add(curNode.r);
            }

            if (cur.isEmpty()) {
                if (thisl >= nextl && nextl != 0) {
                    return false;
                }
                thisl = 0;
                nextl = 0;
                LinkedList<Node> temp = cur;
                cur = next;
                next = temp;
            }
        }
        return true;
    }
}

class Node {
    int id;
    int val;
    Node l;
    Node r;

    public Node(int id, int val) {
        this.id = id;
        this.val = val;
    }
}


