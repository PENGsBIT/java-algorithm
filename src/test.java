import 树.TreeNode;

import java.util.*;

public class test {

    //请实现两个函数，分别用来序列化和反序列化二叉树。
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

//    public TreeNode Deserialize(String str) {
//        deserializeStr = str;
//        return Deserialize();
//    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        test t=new test();
        t.deserializeStr=t.Serialize(root);
        System.out.println(t.deserializeStr);
        System.out.println(t.Deserialize());
    }



    //前序与中序遍历序列构造二叉树

}



