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
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
    private void dfs(TreeNode curr) {
        if (curr == null) return;
        res.add(curr.val);
        dfs(curr.left);
        dfs(curr.right);
    }
}