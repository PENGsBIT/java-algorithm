package AAA真题系列AAA.微软.树;
/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-12 22:34
 **/

import 树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * @Create: 2019-09-12 22:34
 **/


public class 树路径总和II {
    public static List<List<Integer>> result = new LinkedList<List<Integer>>();
    public static List<Integer> currentResult = new LinkedList<Integer>();

    public static void findPaths(TreeNode root, int sum) {
        if (root == null)
            return;
        currentResult.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            findPaths(root.left, sum - root.val);
            findPaths(root.right, sum - root.val);
        }
        currentResult.remove(currentResult.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        findPaths(root, 7);
        System.out.println(result);
    }
}
