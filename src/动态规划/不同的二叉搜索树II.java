package 动态规划;/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-09-23 15:36
 **/

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpc
 * @Description: leetcode
 * @Create: 2019-09-23 15:36
 **/

//95. 不同的二叉搜索树 II
    //给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//
//示例:
//
//输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//

public class 不同的二叉搜索树II {
    // 1..n is the in-order traversal for any BST with nodes 1 to n.
    // So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1),
    // and the right subtree will contain elements (i+1) to n.
    // I use recursive calls to get back all possible trees for left
    // and right subtrees and combine them in all possible ways with the root.
    public static List<TreeNode> generateTrees(int n) {

        return genTrees(1,n);
    }

    public static List<TreeNode> genTrees (int start, int end)
    {

        List<TreeNode> list = new ArrayList<>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(2));
    }
}
