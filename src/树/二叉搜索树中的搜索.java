package 树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-31 22:31
 **/

/**
 * @Author: zpc
 * @Description: leetcode700. 二叉搜索树中的搜索
 * @Create: 2019-08-31 22:31
 **/


public class 二叉搜索树中的搜索 {
    //recursion:递归
    public static TreeNode recursionSearchBST(TreeNode root, int target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        if (root.val == target) {
            return root;
        } else {
            return target<root.val? recursionSearchBST(root.left,target):recursionSearchBST(root.right,target);
        }
    }
    //iteration:迭代
    public TreeNode InterationSearchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }
}
