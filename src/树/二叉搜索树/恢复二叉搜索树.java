package 树.二叉搜索树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 16:08
 **/

import 树.TreeNode;

/**
 * @Author: zpc
 * @Description: leetcode99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
 * @Create: 2019-09-23 16:08
 **/


public class 恢复二叉搜索树 {
    static TreeNode firstElement = null;
    static TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        InOrderTraverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private static void InOrderTraverse(TreeNode curNode) {

        if (curNode == null)
            return;

        InOrderTraverse(curNode.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= curNode.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= curNode.val) {
            secondElement = curNode;
        }
        prevElement = curNode;

        // End of "do some business"

        InOrderTraverse(curNode.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        root.left.right=new TreeNode(4);
        System.out.println(root);
        recoverTree(root);
        System.out.println(root);
    }
}
