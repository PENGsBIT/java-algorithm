package HashMap;

//public class MyHashMap<K, V> implements BaseMap<K, V>{
//    private int defaultLength = 16;//默认长度
//    private double defaultAddFactor = 0.75;//默认负载因子
//    private double useSize;//使用数组位置的数量
//    private Entry<K, V>[] table;//数组
//    public MyHashMap() {
//        this(16, 0.75);
//    }
//
//    public MyHashMap(int defaultLength, double defaultAddFactor) {
//        if (defaultLength < 0) {
//            throw new IllegalArgumentException("数组异常");
//        }
//        if (defaultAddFactor <= 0 || Double.isNaN(defaultAddFactor)) {
//            throw new IllegalArgumentException("因子异常");
//        }
//        this.defaultLength = defaultLength;
//        this.defaultAddFactor = defaultAddFactor;
//        table = new Entry[defaultLength];
//    }
//}
