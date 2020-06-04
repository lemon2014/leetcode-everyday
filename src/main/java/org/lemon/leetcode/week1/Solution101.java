package org.lemon.leetcode.week1;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 对称二叉树, 使用广度优先, 依次遍历, 最后的叶子节点判断 中序和后序相等即可
 *
 * 使用镜像的方式
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
