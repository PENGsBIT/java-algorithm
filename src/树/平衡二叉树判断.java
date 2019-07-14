package 树;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-14 11:41
 **/

public class 平衡二叉树判断 {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced=false;
        }
        return 1 + Math.max(left, right);
    }
}
