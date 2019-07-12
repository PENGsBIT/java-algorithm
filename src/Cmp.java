import java.util.*;

public class Cmp {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        LinkedList<Integer> lin=new LinkedList<Integer>();
        int[]a=new int[10];
        for(int i=0;i<a.length;i++){
            a[i]=i;
        }
        Comparator<Integer> cmp=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        Comparator<Integer> cmp2=new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int str1= Integer.parseInt(i1+""+i2);
                int str2= Integer.parseInt(i2+""+i1);
                return str2-str1;
            }
        };
        arr.add(345);
        arr.add(12);
        arr.add(6);
        Collections.sort(arr,cmp2);
        System.out.println(arr);

        //TreeMap底层是根据红黑树的数据结构构建的，默认是根据key的自然排序来组织（比如integer的大小，String的字典排序）。
        // 所以，TreeMap只能根据key来排序，是不能根据value来排序的（否则key来排序根本就不能形成TreeMap）。
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<HashMap.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }


    }
}
