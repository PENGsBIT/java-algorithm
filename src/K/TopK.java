package K;

import java.util.*;

public class TopK {
    public static void main(String[] args) throws Exception {
        // System.out.println(maxProfit(new int[]{1,2,3,0,2}));
        Integer[]a={1, 3, 3, 2, 4, 6};
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(qselect(nums, 2));
    }

    public static List<Integer> qselect(List<Integer> nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.size() < k) {
            return nums;
        }
        Random random = new Random();
        int index = random.nextInt(nums.size() - 1);
//        index = nums.size() - 1;
        List<Integer> left = new ArrayList<>();
        for (int num : nums) {
            if (num >= nums.get(index)) {
                list.add(num);
            } else {
                left.add(num);
            }
        }
        if (list.size() == k) {
            return list;
        } else if (list.size() > k) {
            return qselect(list, k);
        } else {
            left = qselect(left, k-list.size());
            list.addAll(left);
            return list;
        }
    }
//
    public ArrayList<Integer> GetLeastNumbers_Solution(Integer[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }

    public void findKthSmallest(Integer[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(Integer[] nums, int l, int h) {
        int p = nums[l];     /* 切分元素 */
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(Integer[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    //大小为 K 的最小堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
