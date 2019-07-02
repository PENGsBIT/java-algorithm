package tree;

public class 任意两个结点路径长度中的最大值 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }
    public int deep(TreeNode root){
        if(root==null)return 0;
        int left=deep(root.left);
        int right=deep(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
