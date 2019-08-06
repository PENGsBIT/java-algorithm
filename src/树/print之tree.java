package 树;

import java.util.LinkedList;

public class print之tree {
    private class BinaryNode{
        int ele;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int ele) {
            this.ele = ele;
            left = right = null;
        }

        @Override
        public String toString() {
            return ele + " ";
        }
    }

    private BinaryNode root;

    //根据数组 arr 中的元素构造一棵二叉排序树
    public void  buildTree(int[] arr){
        for (int node : arr) {
            insert(node);
        }
    }

    private void insert(int ele){
        root =  insert(root, ele);
    }

    private BinaryNode insert(BinaryNode root, int ele){
        //递归的结束条件.base condition
        if(root == null)
            return new BinaryNode(ele);

        if(root.ele > ele)
            root.left = insert(root.left, ele);
        else if(root.ele < ele)
            root.right = insert(root.right, ele);
        else
            root.left = insert(root.left, ele);

        return root;//若某结点的左右孩子不空,在后续的递归调用中该结点的左右指针是不会变的.
    }


    public void zigPrintTree(){
        if(root == null)
            return;
        LinkedList<BinaryNode> stack = new LinkedList<>();//打印当前行的栈(只保存奇数行的结点)
        LinkedList<BinaryNode> nextStack = new LinkedList<>();//打印下一行的栈(只保存偶数行的结点)
        boolean odd=true;//标记行号(根为第一行)
        stack.push(root);//根属于奇数行的结点(第一行)
        while(!stack.isEmpty() || !nextStack.isEmpty())
        {
            if(odd)//奇数行,左孩子先入栈
            {
                while(!stack.isEmpty())
                {
                    BinaryNode current = stack.pop();
                    System.out.print(current);//打印当前结点
                    if(current.left != null)
                        nextStack.push(current.left);//先左孩子入栈
                    if(current.right != null)
                        nextStack.push(current.right);//再右孩子入栈
                }
                System.out.println();//该层结点已经打印完,输出换行符
            }else{//偶数行,右孩子先入栈
                while(!nextStack.isEmpty())
                {
                    BinaryNode current = nextStack.pop();
                    System.out.print(current);
                    if(current.right != null)//先右孩子入栈
                        stack.push(current.right);
                    if(current.left != null)//再左孩子入栈
                        stack.push(current.left);
                }
                System.out.println();
            }
            odd=!odd;
        }
    }

    public static void main(String[] args) {
        int[] eles = {20,10,30,5,12,25,40};
//        int[] eles = {20,10,30,12,25};
        print之tree t=new print之tree();
        t.buildTree(eles);
        t.zigPrintTree();
    }
}
