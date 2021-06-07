package mina.leetcode.tree;

import java.util.ArrayList;
import java.util.List;




public class Inorder_94 {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.left);
        result.add(node.val);
        inorderTraversal(node.right);
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
