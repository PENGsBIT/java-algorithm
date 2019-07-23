package 树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-22 16:56
 **/

import java.util.ArrayList;

/**
 * @Author: zpc
 * @Description: 把二叉树打印成多行
 * @Create: 2019-07-22 16:56
 **/


public class 把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
