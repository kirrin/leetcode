package mina.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/submissions/
 * 给定n，求BST的个数
 * 思路：利用BST树的特性，左子树个数*右子树个数，动态规划缓存重复结果
 */
public class BSTNum_96 {

    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int low, int high) {
        if (low > high) {
            return 1;
        }
        if (memo[low][high] > 0) {
            return memo[low][high];
        }

        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            res += left * right;
        }

        memo[low][high] = res;
        return res;
    }
}
