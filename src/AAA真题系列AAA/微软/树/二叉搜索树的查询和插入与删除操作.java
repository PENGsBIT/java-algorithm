package AAA真题系列AAA.微软.树;
/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-08-31 22:25
 **/

import 树.TreeNode;

/**
 * @Author: zpc
 * @Description: 二叉搜索树的查询、插入与删除操作
 * 700. 二叉搜索树中的搜索
 * 701. 二叉搜索树中的插入操作
 * 450. 删除二叉搜索树中的节点
 * @Create: 2019-08-31 22:25
 **/


public class 二叉搜索树的查询和插入与删除操作 {

    public static TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        if (root.val == target) {
            return root;
        } else {
            return target<root.val? searchBST(root.left,target):searchBST(root.right,target);
        }
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

//    Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
//    Once the node is found, have to handle the below 4 cases
//    node doesn't have left or right - return null
//    node only has left subtree- return the left subtree
//    node only has right subtree- return the right subtree
//    node has both left and right - find the minimum value in the right subtree, set that value to the currently found node, then recursively delete the minimum value in the right subtree
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        System.out.println(deleteNode(root,2));
    }
}
