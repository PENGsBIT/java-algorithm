package 树;

import java.util.*;

public class 树的右视图 {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        System.out.println(rightSideView2(root));
    }
    //no递归
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                root = queue.poll();
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
                if (n == 0) res.add(root.val);  //将该层的最右一个节点添加到结果集中
            }
        }
        return res;
    }

    //递归
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private static void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        }
        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
    }


}
