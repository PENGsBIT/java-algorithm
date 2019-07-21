package 树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-20 17:03
 **/

/**
 * @Author: zpc
 * @Description: 二叉树的镜像
 * @Create: 2019-07-20 17:03
 **/


public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null||(root.left==null&&root.right==null)) {
            return root;
        }
        TreeNode temp=root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
