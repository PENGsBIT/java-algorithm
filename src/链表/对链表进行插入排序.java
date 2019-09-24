package 链表;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-24 14:26
 **/

/**
 * @Author: zpc
 * @Description: leetcode147. 对链表进行插入排序
 * @Create: 2019-09-24 14:26
 **/


public class 对链表进行插入排序 {
    public static ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(5);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        insertionSortList(root);
    }
}
