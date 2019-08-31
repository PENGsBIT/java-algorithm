package 树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-31 22:35
 **/

/**
 * @Author: zpc
 * @Description: 701. 二叉搜索树中的插入操作
 * @Create: 2019-08-31 22:35
 **/


public class 二叉搜索树中的插入操作 {
    //recursion:递归
    public TreeNode recursionInsertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = recursionInsertIntoBST(root.left, val);
        } else {
            root.right = recursionInsertIntoBST(root.right, val);
        }
        return root;
    }
    //iteration:迭代
    public TreeNode iterationInsertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode cur = root;
        while(true) {
            if(cur.val <= val) {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
