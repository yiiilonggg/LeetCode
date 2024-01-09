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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1, new ArrayList<>()).equals(dfs(root2, new ArrayList<>()));
    }
    public List<Integer> dfs(TreeNode curr, List<Integer> sequence) {
        if (curr == null) return sequence;
        if (curr.left == null && curr.right == null) {
            sequence.add(curr.val);
        } else {
            dfs(curr.left, sequence);
            dfs(curr.right, sequence);
        }
        return sequence;
    }
}
