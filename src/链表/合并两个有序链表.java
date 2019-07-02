package 链表;

public class 合并两个有序链表 {
    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode node=null;
        if(l1.val<=l2.val){
            node=l1;
            mergeTwoLists(l1.next,l2);
        }
        else {
            node=l2;
            mergeTwoLists(l1,l2.next);
        }
        return node;
    }

    //非递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode cur=node;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }else {
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
           if(l1!=null){
               cur.next=l1;
           }else {
               cur.next=l2;
           }
        }
        return node.next;
    }
}
