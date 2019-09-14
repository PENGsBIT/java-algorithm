package 链表;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-14 21:26
 **/

/**
 * @Author: zpc
 * @Description: leetcode160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * @Create: 2019-09-14 21:26
 **/


public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;
        //拼接两链表。
        //设长-短链表为 C，短-长链表为 D （分别代表长链表在前和短链表在前的拼接链表），
        // 则当 C 走到长短链表交接处时，D 走在长链表中，且与长链表头距离为 长度差;
        //A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，
        // pB 比 pA 少经过 2个结点，会先到达尾部。将 pB 重定向到 A 的头结点，pA 重定向到 B 的头结点后，
        // pB 要比 pA 多走 2 个结点。因此，它们会同时到达交点。
        //如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时
        // 记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
        while( a != b){
            //对于第一次迭代的末尾，我们只是将指针重置为另一个链表的头部
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }

    //通常做这种题的思路是设定两个指针分别指向两个链表头部，一起向前走直到其中一个到达末端，
    // 另一个与末端距离则是两链表的 长度差。再通过长链表指针先走的方式消除长度差，最终两链表即可同时走到相交点
    private ListNode intersect(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode cur1 = head1;
        ListNode cur2 = head2;

        int n = 0;

        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        //令 cur1 指向 较长的链表，cur2 指向较短的链表
        if (n > 0) {
            cur1 = head1;
            cur2 = head2;
        } else {
            cur1 = head2;
            cur2 = head1;
        }

        n = Math.abs(n);

        //较长的链表先走 n 步
        while (n != 0) {
            cur1 = cur1.next;
        }

        //两个链表一起走 第一次相等节点即为相交的第一个节点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

}
