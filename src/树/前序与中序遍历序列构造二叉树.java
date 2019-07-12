package 树;

import java.util.Arrays;

public class 前序与中序遍历序列构造二叉树 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode tree = buildTree(new int[] { 1, 2, 4, 3 }, new int[] { 4, 2, 1, 3 });
        System.out.println(tree);
    }
}
