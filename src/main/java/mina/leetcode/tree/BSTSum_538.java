package mina.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * 解题思路：中序遍历，从右到左。如果是求小于等于节点的值，就从左到右
 */
public class BSTSum_538 {

    int sum=0;
    public TreeNode convertBST(TreeNode root) {

        inOrder(root);
        return root;

    }

    private void inOrder(TreeNode node) {
        if (null == node) {
            return;
        }
        inOrder(node.right);
        sum += node.val;
        node.val = sum;
        inOrder(node.left);
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
