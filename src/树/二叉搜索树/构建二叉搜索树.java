package 树.二叉搜索树;

/**
 * @program: javatest
 * @author: zpc
 * @create: 2019-07-13 22:50
 **/

public class 构建二叉搜索树 {
}

class BST {
    BST left;
    BST right;
    int val;

    public BST(int val) {
        this.val = val;
    }

    public void addNode(int val) {
        if (this.val == val) {
            throw new IllegalArgumentException();
        }
        if (val > this.val) {
            if (this.right != null) {
                this.right.addNode(val);
            } else {
                this.right = new BST(val);
            }
        } else {
            if (this.left != null) {
                this.left.addNode(val);
            } else {
                this.left = new BST(val);
            }
        }
    }

    public void traversePreOrder() {
        System.out.println(this.val);
        if (this.left != null) {
            this.left.traversePreOrder();
        }
        if (this.right != null) {
            this.right.traversePreOrder();
        }
    }

    // Visit left sub-tree, then node and then, right sub-tree
    public void traverseInOrder() {
        if (this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.traverseInOrder();
        }
    }

    // Visit left sub-tree, then right sub-tree and then the node
    public void traversePostOrder() {
        if (this.left != null) {
            this.left.traversePostOrder();
        }
        if (this.right != null) {
            this.right.traversePostOrder();
        }
        System.out.println(this.val);
    }
}
