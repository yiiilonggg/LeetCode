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
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode curr, int total) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) {
            res += total + curr.val;
            return;
        }
        dfs(curr.left, (total + curr.val) * 10);
        dfs(curr.right, (total + curr.val) * 10);
    }
}