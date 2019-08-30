package AAA真题系列AAA.微软;

//leetcode 110. 平衡二叉树
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//示例 1:
//
//给定二叉树 [3,9,20,null,null,15,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回 true 。
//
//示例 2:
//
//给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//返回 false 。
//

import 树.TreeNode;

public class 判断平衡二叉树 {
    //O(nlongn)双递归 n节点logn高度
    private int depth (TreeNode root) {
        if (root == null) return 0;
        return Math.max (depth(root.left), depth (root.right)) + 1;
    }

    public boolean isBalanced (TreeNode root) {
        if (root == null) return true;
        int left=depth(root.left);
        int right=depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    //方法时间复杂度O(N),空间复杂度O(H)
    //优化后的方法为：对于每一个节点，
    // 我们通过checkDepth方法递归获得左右子树的深度，如果子树是平衡的，则返回真实的深度，若不平衡，直接返回-1
    public boolean DFSisBalanced(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;
        //方法是如果我们发现子树不平衡，则不计算具体的深度，而是直接返回-1。
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
