package 链表;

public class 链表相加求和 {

    public ListNode addLists(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        //进位标识
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int sum = 0;

        ListNode addHead = new ListNode(0);
        ListNode dummyHead = addHead;

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while (cur1 != null || cur2 != null) {
            n1 = cur1 == null ? 0 : cur1.val;
            n2 = cur2 == null ? 0 : cur2.val;

            sum = n1 + n2 + ca;

            ListNode ListNode = new ListNode(sum % 10);
            System.out.println( sum % 10);
            ca = sum / 10;

            dummyHead.next = ListNode;

            dummyHead = dummyHead.next;

            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }

        if (ca > 0) {
            dummyHead.next = new ListNode(ca);
        }

        head1 = reverseList(head1);
        head2 = reverseList(head2);

        addHead = addHead.next;
        return reverseList(addHead);
    }

    private  ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //注意这里返回的是赋值当前比较元素
        return pre;
    }


}
