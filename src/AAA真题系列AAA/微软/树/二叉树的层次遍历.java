package AAA真题系列AAA.微软.树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-20 14:00
 **/

import 树.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zpc
 * @Description: leetcode102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @Create: 2019-09-20 14:00
 **/


public class 二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        if(root == null) return ans;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<levelNum; i++) {
                TreeNode cur = queue.peek();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                subList.add(queue.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }
}
