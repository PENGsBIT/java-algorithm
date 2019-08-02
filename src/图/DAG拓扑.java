package 图;

import java.util.*;

public class DAG拓扑 {
    public static void main(String[] args) {
        tuoPuOrder(4,new int[][]{
                {0,1},
                {0,2},
                {1,3},
                {2,3}
        });
    }

    public static void tuoPuOrder(int n, int[][] chudu) {
        //Map<String, List<String>> map = new HashMap<>();
        //如果我们要放一个元素进去，很多人会这么写：
        //
        //List<String> list = map.get("list1");
        //if (list == null) {
        //  list = new ArrayList<>();
        //  map.put("list1", list);
        //}
        //list.add("A");
        //实际上从 Java 8 开始，Map 提供了 computeIfAbsent() 方法，我们可以写成一行即可：
        //
        //map.computeIfAbsent("list1", k -> new ArrayList<>()).add("A");
        //出度变入度
        Map<Integer, List<Integer>> rudu = new HashMap<>();
        for (int[] node : chudu) {
            rudu.computeIfAbsent(node[1], k -> new ArrayList<>()).add(node[0]);
        }
//        for (int i = 0; i < n; i++) {
//            List<Integer> p=new ArrayList<>();
//                if (rudu.containsKey(chudu[i][1])) {
//                    rudu.get(chudu[i][1]).add(chudu[i][0]);
//                }
//               else {
//                   p.add(chudu[i][0]);
//                   rudu.put(chudu[i][1],p);
//                }
//        }
        //从入度为0的开始输出
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty())
        {
           Integer cur=queue.poll();
            System.out.print(cur+" ");
            for(Integer node :rudu.keySet())
            {
                if(rudu.get(node).contains(cur)){
                    rudu.get(node).remove(cur);
                    if(rudu.get(node).isEmpty()){
                        queue.add(node);
                    }
                }
            }
        }
    }
}
