package AAA真题系列AAA.微软.树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-02 23:03
 **/

import 树.TreeNode;

/**
 * @Author: zpc
 * @Description: leetcode298.二叉树最长连续序列LCS
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * For example,
 * <p>
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * @Create: 2019-09-02 23:03
 **/


public class 二叉树最长连续序列LCS {
    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        rec(root, 1);
        return max;
    }

    private void rec(TreeNode n, int c) {
        if (n.left != null) {
            if (n.val + 1 == n.left.val) {
                rec(n.left, c + 1);
                max = Math.max(max, c + 1);
            } else rec(n.left, 1);
        }

        if (n.right != null) {
            if (n.val + 1 == n.right.val) {
                rec(n.right, c + 1);
                max = Math.max(max, c + 1);
            } else rec(n.right, 1);
        }
    }


}
