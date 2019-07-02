package 图;

import java.util.*;

public class DAG拓扑 {
    public static void main(String[] args) {
        tuoPuOrder(4,new int[][]{{0,1},{0,2},{1,3},{2,3}});
    }
//出度变入度
    public static void tuoPuOrder(int n, int[][] chudu) {
        Map<Integer,List<Integer>> rudu= new HashMap();
        for (int i = 0; i < n; i++) {
            List<Integer> p=new ArrayList<>();
                if (rudu.containsKey(chudu[i][1])) {
                    rudu.get(chudu[i][1]).add(chudu[i][0]);
                }
               else {
                   p.add(chudu[i][0]);
                   rudu.put(chudu[i][1],p);
                }
        }
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
