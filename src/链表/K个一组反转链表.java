package 链表;

public class K个一组反转链表 {
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        a.next= new ListNode(2);
        a.next.next= new ListNode(3);
        a.next.next.next= new ListNode(4);
        a.next.next.next.next= new ListNode(5);
        //ListNode res =reverseKGroup(a,3);

       ListNode res =reverse(a,3);
       // reverseKGroup1(a,3);
        System.out.println(res);
    }
    public static ListNode reverse (ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        /*reverse first k nodes of the linked list */
        while (current != null && count < k) {
            next  = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

    /* next is now a pointer to (k+1)th ListNode
       Recursively call for the list starting from current.
       And make rest of the list as next of first ListNode */
        if(next !=  null) {
            head.next = reverse(next, k);
        }

        /* prev is new head of the input list */
        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            count++;
            if(count == k){
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }
    public static ListNode reverse(ListNode pre, ListNode end){
        if(pre == null || pre.next == null){
            return pre;
        }
        ListNode head = pre.next;
        ListNode cur = pre.next.next;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }


    public static ListNode reverseKGroup1(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found\
            // reverse list with k+1 node as head
            curr = reverseKGroup1(curr, k);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                // tmp - next head in direct part
                ListNode tmp = head.next;
                // preappending "direct" head to the reversed list
                head.next = curr;
                // move head of reversed part to a new node
                curr = head;
                // move "direct" head to the next node in direct part
                head = tmp;
            }
            head = curr;
        }
        return head;

    }
}
