package AAA真题系列AAA.微软.树;

//leetcode 108 将有序数组转换为二叉搜索树
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//示例:
//
//给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//

import 树.TreeNode;

public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = builder(num, 0, num.length - 1);
        return head;
    }

    public TreeNode builder(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = low + (high-low)/2; // avoids integer overflow
        TreeNode node = new TreeNode(num[mid]);
        node.left = builder(num, low, mid - 1);
        node.right = builder(num, mid + 1, high);
        return node;
    }
}
