package org.lemon.datastructure.trietree;


import java.util.List;

/**
 * 英文字母的字典树
 */
public class TrieTree {

    class TreeNode {
        char data;
        TreeNode[] children;
        boolean isEnd;

        public TreeNode(char data) {
            children = new TreeNode[26];
            isEnd = false;
            this.data = data;
        }
    }

    private TreeNode root = new TreeNode('/');

    public void insert(String str) {
        TreeNode p = root;
        char[] charArr = str.toLowerCase().toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 'a';
            if (null == p.children[index]) {
                TreeNode node = new TreeNode(charArr[i]);
                p.children[index] = node;
            }
            p = p.children[index];
        }
        p.isEnd = true;
    }

    public boolean find(String str) {
        TreeNode p = root;
        char[] charArr = str.toLowerCase().toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            TreeNode node = p.children[charArr[i] - 'a'];
            if (node == null) {
                return false;
            } else {
                p = node;
            }
        }
        return p.isEnd;
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("Java");
        tree.insert("jack");
        tree.insert("jenkins");
        tree.insert("hello");
        System.out.println(tree.find("jack"));
        System.out.println(tree.find("jetty"));
        System.out.println(tree.find("jac"));
        System.out.println(tree.find("hel"));
        System.out.println(tree.find("hello"));
    }

}



