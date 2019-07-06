package 链表;

import static 链表.寻找单链表的中间元素.searchListMid;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-06 22:31
 **/

public class 单链表的归并排序 {
    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //寻找中间节点
        ListNode mid = searchListMid(head);
        ListNode left = head, right = mid.next;
        left = mergeSortList(left);
        right = mergeSortList(right);
        return merge(left, right);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        //由于链表不能方便的拿到链表长度 所以一般使用 while l == null 表示链表遍历到尾部
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        //当有一半链表遍历完成后 另外一个链表一定只剩下最后一个元素（链表为基数）
        if (l != null) {
            cur.next = l;
        } else if (r != null) {
            cur.next = r;
        }
        return root.next;
    }
}
