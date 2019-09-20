package AAA真题系列AAA.微软.树;

import 树.TreeNode;

public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
