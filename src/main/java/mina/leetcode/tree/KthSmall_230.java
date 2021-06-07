package mina.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 寻找二叉搜索树中第K小的元素
 *
 * 解题思路：中序遍历
  */


public class KthSmall_230 {

    int count = 0;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode node, int k) {
        if (null == node) {
            return;
        }
        traverse(node.left, k);
        count++;
        if (k == count) {
            result = node.val;
            return;
        }
        traverse(node.right, k);
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
