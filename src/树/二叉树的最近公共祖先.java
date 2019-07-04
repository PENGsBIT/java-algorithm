package 树;

public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        int p=4;
        int q=3;
        System.out.println(lowestCommonAncestor(root,p,q).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        // LCA 问题，查阅相关资料
        if (root == null) {
            return root;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
