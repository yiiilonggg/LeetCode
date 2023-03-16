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
    public int curr;
    public Map<Integer, Integer> seen;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        curr = n - 1;
        seen = new HashMap<>();
        for (int i = 0; i < n; i++) seen.put(inorder[i], i);
        return dfs(0, n - 1, postorder);
    }
    public TreeNode dfs(int left, int right, int[] postorder) {
        if (left > right) return null;
        TreeNode node = new TreeNode(postorder[curr]);
        curr--;
        node.right = dfs(seen.get(node.val) + 1, right, postorder);
        node.left = dfs(left, seen.get(node.val) - 1, postorder);
        return node;
    }
}