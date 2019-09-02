package AAA真题系列AAA.微软.树;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-02 22:14
 **/

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpc
 * @Description: 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @Create: 2019-09-02 22:14
 **/


public class 二叉树的直径 {
    public static int max = 0;

    public int getDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getDiameter(node.left);
        int r = getDiameter(node.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
    public void longest(TreeNode root) {
        int top = 0, longest = 0;  //longest是最长路径的长度
        TreeNode p = root;
        TreeNode []l=new TreeNode[100]; // l和s都用来做栈，记录路径
        TreeNode  []s=new TreeNode[100]; //其中，l是最终的路径，s是临时记录的路径
        int[] tag=new int[100]; //记录是否被访问过
        while (p != null || top > 0){
            while (p!=null){
                s[++top] = p;
                //tag[top] = 0; //表示当前节点的右分支还没有被访问过
                p = p.left;
            }
            if (tag[top] == 1) {  //如果被访问过，就看是不是叶子，只有是叶子节点才判断长度
                if (s[top].left == null && s[top].right == null){
                    if (top > longest){
                        for (int i = 1; i <= top; i++)
                            l[i] = s[i];
                        longest = top;
                        top--; //保留当前的最长路径，然后退栈
                    }
                }
            }
            else if (top > 0){
                tag[top] = 1;
                p = s[top].right;
            }
//            cout << "路径长度：" << longest << endl << "路径：";
//            for (int k = 0; k < longest; k++)
//            {
//                cout << s[k]->data << " ";
//            }

        }
    }
    /**
     * longestPath: 递归求解给定二叉树的一条最长路径 如果有多条，输出其中一条
     * @param root  给定二叉树的根结点
     * @param longestPath 存放二叉树的最长路径上的结点
     */
    static void longestPath(TreeNode root, List<TreeNode> longestPath) {
        if (root != null) {
            longestPath.add(root);
            if (root.left == null && root.right == null) { // 左右子树均空
                return ;
            }
            List<TreeNode> leftLongestPath = new ArrayList<>();
            List<TreeNode> rightLongestPath = new ArrayList<>();
            longestPath(root.left, leftLongestPath);
            longestPath(root.right, rightLongestPath);
            if (leftLongestPath.size() >= rightLongestPath.size()) {
                longestPath.addAll(leftLongestPath);
            } else {
                longestPath.addAll(rightLongestPath);
            }
        }
    }
    public static List<TreeNode>res;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        res=new ArrayList<TreeNode>();
        longestPath(root,res);
        for (TreeNode re : res) {
            System.out.println(re.val);
        }
    }
}
