package 树.二叉搜索树;

class Trie {
    //    public TrieTree() {
//    }
//
//    public static void main(String[] args) {
//        TrieTree t = new TrieTree();
//        String s = "wqe";
//        t.insert(s);
//        String i = "wqeab";
//        t.insert(i);
//    }

    private Node root = new Node();

    private void insertWord(String word, Node node) {
        if (node == null)
            return;
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (node.children[index] == null) {
            node.children[index] = new Node();
        }
        insertWord(word.substring(1), node.children[index]);
    }

    private boolean searchWord(String word, Node node) {
        if (node == null)
            return false;
        if (word.length() == 0)
            return node.isLeaf;
        int index = indexForChar(word.charAt(0));
        return searchWord(word.substring(1), node.children[index]);
    }

    private boolean startWithWord(String prefix, Node node) {
        if (node == null)
            return false;
        if (prefix.length() == 0)
            return true;
        int index = indexForChar(prefix.charAt(0));
        return startWithWord(prefix.substring(1), node.children[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }

    private class Node {
        Node[] children = new Node[26];

        boolean isLeaf;
    }
}
