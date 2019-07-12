package 树;

import java.util.ArrayList;
import java.util.List;

public class 前序与中序序列化二叉树 {
    private static ArrayList<Integer> preOrder=new ArrayList<Integer>();
    private static ArrayList<Integer> midOrder=new ArrayList<Integer>();

    public static void serialize(TreeNode root) {
        preTravel(root);
        midTravel(root);
    }

    private static void midTravel(TreeNode root) {
        if (root != null) {
            midTravel(root.left);
            midOrder.add(root.val);
            midTravel(root.right);
        }
    }

    private static void preTravel(TreeNode root) {
        if (root != null) {
            preOrder.add(root.val);
            preTravel(root.left);
            preTravel(root.right);
        }

    }

    public static TreeNode deSerialize(List<Integer> pre,List<Integer> mid) {
        if (pre.size() == 0 || mid.size() == 0) {
            return null;
        }
        TreeNode root=new TreeNode(pre.get(0));
        for (int i = 0; i <mid.size() ; i++) {
            if (pre.get(0).equals(mid.get(i))) {
                root.left=deSerialize( pre.subList(1, i+1),mid.subList(0, i));
                root.right = deSerialize(pre.subList(i+1, pre.size()),mid.subList(i+1, mid.size()));
            }
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);

        serialize(root);
        System.out.println(preOrder);
        System.out.println(midOrder);

        System.out.println(deSerialize(preOrder,midOrder));;
    }
}
