package 链表;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-06 23:00
 **/

public class 翻转部分单链表 {

    private ListNode reversePartList(ListNode head, int from, int to) {

        ListNode dummyHead = head;

        int len = 0;

        ListNode fPosPre = null;
        ListNode tPosNext = null;
        ListNode toPos = null;
        ListNode fromPos = null;

        while (dummyHead != null) {
            //因为 len = 0 开始的所以 len 先做自增一
            len++;

            if (len == from) {
                fromPos = dummyHead;
            } else if (len == from - 1) {
                fPosPre = dummyHead;
            } else if (len == to + 1) {
                tPosNext = dummyHead;
            } else if (len == to) {
                toPos = dummyHead;
            }

            dummyHead = dummyHead.next;
        }

        //不满足条件不翻转链表
        if (from > to || from < 0 || to > len || from > len) {
            return head;
        }


        ListNode cur = fromPos;
        ListNode pre = tPosNext;
        ListNode next = null;

        while (cur != null && cur != tPosNext) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 如果翻转的起点不是 head 则返回 head
        if (fPosPre != null) {
            fPosPre.next = pre;
            return head;
        }
        // 如果反转的链表是起点，那么翻转后 toPos 就是头结点
        return toPos;
    }

}
