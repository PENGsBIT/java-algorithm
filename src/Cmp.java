import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

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
        Collections.sort(arr,cmp);
        System.out.println(arr);


    }
}
