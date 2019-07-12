package 全排列;

import java.util.Arrays;
//输入一个字符串，按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
public class 字典全排列 {

    public static int getMin(char[]input,int index){
        char min=input[index];
        int minIndex=index+1;
        char result='z';
        for(int i=index+1;i<input.length;i++){
            if(input[i]>min&&input[i]<result){
                result=input[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static void exchange(char []input,int index,int minIndex){
        char temp=input[index];
        input[index]=input[minIndex];
        input[minIndex]=temp;
    }
    public static void reverse(char input[],int first,int end) {
        while(first<end){
            exchange(input,first,end);
            first++;
            end--;
        }
    }
    public static void getDictionary(char c[]){
        System.out.println(new String(c));
        //boolean flag=true;
        //从右向左，找出第一破坏递增顺序的元素，记其位置为i;
        int i=0;
        while(true){
            i=c.length-1;
            for(;i>0;i--){
                if(c[i-1]<c[i])break;
            }
            if(i==0)break;
            int minIndex=getMin(c,i-1);
            //从右向左，找出第一个大于A[i]的元素，及其位置为j;
            //c. 交换A[i]与A[j]两个元素；
            exchange(c,i-1,minIndex);
            //d. 从i位置往后的所有元素进行逆序排列；
            reverse(c,i,c.length-1);
            System.out.println(new String(c));
        }

    }
    public static void main(String []args){
        String input="cba";
        char [] c=input.toCharArray();
        Arrays.sort(c);
        getDictionary(c);
    }
}
