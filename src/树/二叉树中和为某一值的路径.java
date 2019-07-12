package 树;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        backtracking(root,7,new ArrayList<Integer>());
    }
    private static void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node==null || target-node.val<0)
            return;
        else
            target-=node.val;
        path.add(node.val);
        if (node.right == null && node.right == null && target == 0) {
            System.out.println(path);
        } else {
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }

    }
}
