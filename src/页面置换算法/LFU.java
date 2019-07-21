package 页面置换算法;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-21 20:29
 **/

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @Author: zpc
 * @Description: Least Frequently Used 最近最不常用:淘汰一定时期内被访问次数最少的页
 * 较小的文件和教零碎的文件比如系统文件、应用程序文件 其中：LRU消耗CPU资源较少，LFU消耗CPU资源较多。
 * @Create: 2019-07-21 20:29
 **/


public class LFU {
    //采用map保存的数据
    HashMap<Integer, Integer> vals;
    //键key找到值value和它的使用频率freq
    HashMap<Integer, Integer> counts;
    //借鉴类似操作系统内核处理不同状态进程控制块时的策略，即每种状态的进程控制块维护一个链表，这里就只需为每个频率维护一个链表
    //当两个元素都是Min时就在fre里面找最近不使用的元素
    HashMap<Integer, LinkedHashSet<Integer>> frequency;
    int cap;
    int min = -1;

    public LFU(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        frequency = new HashMap<>();
        frequency.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        frequency.get(count).remove(key);
        if(count==min && frequency.get(count).size()==0)
            min++;
        if(!frequency.containsKey(count+1))
            frequency.put(count+1, new LinkedHashSet<>());
        frequency.get(count+1).add(key);
        return vals.get(key);
    }

    public void set(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
//            vals.put(key, value);
            get(key);
            return;
        }
        if(vals.size() >= cap) {
            int tempMin = frequency.get(this.min).iterator().next();
            //frequency.get(this.min).pollLast();
            frequency.get(this.min).remove(tempMin);
            vals.remove(tempMin);
            //不删除counts是因为要累积评率
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        frequency.get(1).add(key);
    }
    @Override
    public String toString() {
        return "LFU{" +
                "vals=" + vals +
                ", counts=" + counts +
                ", frequency=" + frequency +
                '}';
    }
    public static void main(String[] args) {
        LFU lfu = new LFU(2);
        lfu.set(1, 1);
        lfu.set(2, 2);
        System.out.println(lfu);
        lfu.get(1);        // 返回 1
        System.out.println(lfu);
        lfu.set(1, 1);
        lfu.set(3, 3);    // 去除 key 2
        System.out.println(lfu);
        lfu.get(2);       // 返回 -1 (未找到key 2)
        lfu.get(3);       // 返回 3
        lfu.set(4, 4);    // 去除 key 1
        lfu.get(1);       // 返回 -1 (未找到 key 1)
        lfu.get(3);       // 返回 3
        lfu.get(4);       // 返回 4


    }
}
