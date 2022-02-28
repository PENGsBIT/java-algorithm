package 链表;

import org.w3c.dom.Node;

/**
 * @Program: java-algorithm
 * @Author: zhoupengcheng03
 * @Package: 链表
 * @ClassName: 反转链表
 * @Description:
 * @Create: 2022-02-28 20:03
 **/
public class 反转链表 {
    //时间复杂度：O(n)，其中 nn 是链表的长度。需要遍历链表一次。
    //空间复杂度：O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
