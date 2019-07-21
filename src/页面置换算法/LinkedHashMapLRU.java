package 页面置换算法;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-21 18:30
 **/

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: zpc
 * @Description: Least Recently Used 最近最少被使用:首先淘汰最长时间未被使用的页面
 * 适用于较大的文件比如游戏客户端（最近加载的地图文件）其中：LRU消耗CPU资源较少，LFU消耗CPU资源较多。
 * @Create: 2019-07-21 18:30
 **/


public class LinkedHashMapLRU extends LinkedHashMap {
    private int maxSize;
    // accessOrder false 基于插入顺序  true  基于访问顺序
    //accessOrder模式下，只要执行get或者put等操作的时候，就会产生structural modification
    //从而实现LRU
    public LinkedHashMapLRU(int maxSize) {
        //super(initialCapacity, loadFactor,accessOrder = false);
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    //原始方法默认不需要移除（这是，LinkedHashMap 相当于一个linkedlist），所以，
    // 我们需要 override 这样一个方法，使得当缓存里存放的数据个数超过规定个数后，就把最不常用的移除掉。
    // 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > maxSize;
    }

    public static void main(String[] args) throws Exception {

        //指定缓存最大容量为4
        Map<Integer, Integer> map = new LinkedHashMapLRU(4);
        map.put(9, 3);
        map.put(7, 4);
        map.put(5, 9);
        map.put(3, 4);
        map.put(6, 6);
        map.put(3, 4);
        //总共put了5个元素，超过了指定的缓存最大容量
        //遍历结果
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next().getKey());
        }
    }


}
class OtherLinkedHashMapLRU{
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public OtherLinkedHashMapLRU(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}
