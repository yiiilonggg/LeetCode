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
    public List<Integer> nodes;
    public int minDiffInBST(TreeNode root) {
        nodes = new ArrayList<>();
        dfs(root);
        Collections.sort(nodes);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nodes.size(); i++) res = Math.min(res, nodes.get(i) - nodes.get(i - 1));
        return res;
    }
    public void dfs(TreeNode node) {
        if (node == null) return;
        nodes.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}