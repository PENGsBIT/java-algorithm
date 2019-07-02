package 链表;
import tree.TreeNode;

public class 有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head,null);
    }
    public TreeNode build(ListNode start,ListNode end){
        if(start==end){
            return null;
        }
        ListNode oneStep=start;
        ListNode twoStep=start;
        while(twoStep!=end&&twoStep.next!=end){
            oneStep=oneStep.next;
            twoStep=twoStep.next.next;
        }
        TreeNode root= new TreeNode(oneStep.val);
        root.left=build(start,oneStep);
        root.right=build(oneStep.next,end);
        return root;
    }
}
