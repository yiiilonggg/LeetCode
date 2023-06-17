/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 100001, prev = -1;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode node) {
        if (node.left != null) dfs(node.left);
        if (prev > -1) res = Math.min(res, node.val - prev);
        prev = node.val;
        if (node.right != null) dfs(node.right);
    }
}
