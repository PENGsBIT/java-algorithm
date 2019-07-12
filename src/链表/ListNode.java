package 链表;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +'}'+
                ", next-->" + next
                ;
    }
}
