package 图;

import java.util.*;

public class 带权值的DAG拓扑排序 {
    public static void main(String[] args) {
        Order(new int[][] {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 2, 3 }
            },
            new int[] { 2, 3, 4, 5 });

    }

    private static void Order(int[][] out, int[] values) {

        int n = out.length;
        Map<Integer, List<Integer>> in = new HashMap<>();
        for (int i = 0; i < n; i++) {
            in.put(i, new ArrayList<>());
        }
        for (int[] node : out) {
            in.get(node[1]).add(node[0]);
        }
        //new 一个带权值排序的优先级队列
        Queue<DAGNode> zeroNode = new PriorityQueue<DAGNode>((o1, o2) -> o1.val - o2.val);

        for (Map.Entry<Integer, List<Integer>> entry : in.entrySet()) {
            if (entry.getValue().size() == 0) {
                zeroNode.add(new DAGNode(entry.getKey(), values[entry.getKey()]));
            }
        }

        while (!zeroNode.isEmpty()) {

            DAGNode curNode = zeroNode.poll();
            System.out.println("node:" + curNode.key + " val:" + curNode.val);
            for (Integer key : in.keySet()) {
                if (in.get(key).contains(curNode.key)) {
                    in.get(key).remove((Integer) curNode.key);
                    if (in.get(key).size() == 0) {
                        zeroNode.add(new DAGNode(key, values[key]));
                    }
                }
            }
        }

    }

}

class DAGNode implements Comparator<DAGNode> {
    int key;

    int val;

    public DAGNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int compare(DAGNode o1, DAGNode o2) {
        return o1.val - o2.val;
    }
}

