package 链表;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 22:45
 **/

public class 链表找出环的入口及环的长度 {
//    定义两个指针，快指针每次走两步，慢指针一次走一步，当环存在时，则快指针一定会追上慢指针；
//    追上时使快指针指向链头，然后两个指针同时一步一步走，则再次追上时指针的位置为环开始的位置
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                fast = head;
                while(fast != slow ){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
//    为什么快指针在慢指针走完环一圈之内追上？
//    有环的情况下，在Slow入环时，Fast肯定也在环内，此时有两种情况
//
//    假设F也在同时在入环的第一个节点（环入口为在链头时，同时入环；或者F绕了N圈的环回到环入口），则当第一次追上时，F追了S一圈。
//    假设F不在环入口，则此时F需要追的距离就小于一圈了
//
//    综上：追的过程中，S走的距离<=一圈
//    假定链表头到环入口的距离是len，环入口到slow和fast交汇点的距离为x，环的长度为R。
// slow和fast第一次交汇时，设slow走的长度为：d = len + x，
// 而fast走的长度为：2d = len + nR + x，(n >= 1)，
// 从而我们可以得知：2len + 2x = len + nR + x，即len = nR - x，(n >= 1)
   public ListNode GetCycleEnter(ListNode head, ListNode meetnode)
    {
        ListNode cur=head;
        while (cur != meetnode)
        {
            cur = cur.next;
            meetnode = meetnode.next;
        }
        return cur;
    }
    //方法一、经过环长s，这两个指针第二次相遇,简言之：第一次相遇后，继续按照2 1的步数走，再次相遇时，slot走的步数为环的长度。
    //方法二、从入口点一直next
    public int GetCircleLen(ListNode MeetNode)
    {
        int len = 1;
        ListNode pNode = MeetNode;
        while(MeetNode != pNode.next)
        {
            pNode = pNode.next;
            ++len;
        }
        return len;
    }

}

