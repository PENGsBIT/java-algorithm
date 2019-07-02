package tree;

public class 树展开为链表 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        flatten(root);
    }
    public static void flatten(TreeNode root) {
        change(root);
    }
    private static TreeNode change(TreeNode root) {
        if (root == null) {
            return  null;
        }
        TreeNode left = root.left, right = root.right;
        if (left == null && right == null) {
            return root;
        } else if (left == null && right != null) {
            return change(right);
        } else if (left != null && right == null) {
            root.right = left;
            root.left = null;
            return change(left);
        } else {
            root.right = left;
            root.left = null;
            left = change(left);
            left.right = right;
            return change(right);
        }
    }
}
