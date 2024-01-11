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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val, root.val);
    }
    public int dfs(TreeNode curr, int low, int high) {
        if (curr == null) return high - low;
        low = Math.min(low, curr.val);
        high = Math.max(high, curr.val);
        return Math.max(dfs(curr.left, low, high), dfs(curr.right, low, high));
    }
}
