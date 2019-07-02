import java.util.*;

public class 最小区间 {
    public static void main(String[] args) {

        int [][]a={{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
        List<List<Integer>> nums= new ArrayList<>();
        for (int i = 0; i <a.length ; i++) {
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for (int j = 0; j <a[i].length ; j++) {
                temp.add(a[i][j]);
            }
            nums.add(temp);
        }
            //findminrange(nums);
        smallestRange(nums);
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        //queue is used to save positions <row, col> and sort by value
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
//        Comparator<int[]> cmp=new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        };
//        PriorityQueue<int[]>queue=new PriorityQueue<>(cmp);
        //yes, update two pointers later
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            //put the first element in each row to the queue
            queue.offer(new int[]{i, 0});
            //max is the maximum of the first num in all rows
            max = Math.max(max, nums.get(i).get(0));
        }
        while (queue.size() == nums.size()) {
            //after you polled the smallest:
            //update two pointers;  offer the next one in that row;  update max
            int[] a = queue.poll();
            int row = a[0], col = a[1];
            if (end-start > max-nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col+1 < nums.get(row).size()) {
                queue.offer(new int[]{row, col+1});
                max = Math.max(max, nums.get(row).get(col+1));
            }
        }
        return new int[]{start, end};
    }

    public static int[] findminrange( List<List<Integer>> nums){
        int []res=new int[2];
        Queue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int max=Integer.MIN_VALUE,range=0;
        for (int i = 0; i <nums.size() ; i++) {
            max=Math.max(max,nums.get(i).get(0));
            queue.add(new int[]{i,0,nums.get(i).get(0)});
            range=max-queue.peek()[2];
        }

        while (queue.size() == nums.size()){
            int []a=queue.poll();//a[numskey,index,val]记录nums位置，数组中位置，value
            int numskey=a[0],nkey=a[1],val=a[2];
            if(++nkey<nums.get(numskey).size()){
                queue.add(new int[]{numskey,nkey,nums.get(numskey).get(nkey)});
                max=Math.max(max,nums.get(numskey).get(nkey));
                range=max-queue.peek()[2];
            }
        }
        res[0]=max-range;
        res[1]=max;
        return res;
    }
}
