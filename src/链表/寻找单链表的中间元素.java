package 链表;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-06 22:35
 **/

public class 寻找单链表的中间元素 {
    public static ListNode searchListMid(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode slow=head,fast=head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
