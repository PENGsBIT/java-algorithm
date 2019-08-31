package 树.二叉搜索树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-31 22:16
 **/

import 树.TreeNode;

/**
 * @Author: zpc
 * @Description: leetcode 270.二叉搜索树最接近值查找
 * Given a non-empty binary searchBST tree and a target value, find the value in the BST that is closest to the target.
 * @Create: 2019-08-31 22:16
 **/


public class 二叉搜索树最接近值查找 {
    private int value;
    private void find(TreeNode root, double target) {
        if (Math.abs(root.val-target) < Math.abs(value-target)) value = root.val;
        if (root.val < target && root.right != null) find(root.right, target);
        if (root.val > target && root.left != null) find(root.left, target);
    }
    public int closestValue(TreeNode root, double target) {
        value = root.val;
        find(root, target);
        return value;
    }


}
