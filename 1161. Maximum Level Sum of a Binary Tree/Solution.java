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
    public int maxLevelSum(TreeNode root) {
        int high = root.val, level = 1, currLevel = 1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int l = q.size(), curr = 0;
            for (int i = 0; i < l; i++) {
                TreeNode node = q.pollFirst();
                curr += node.val;
                if (node.left != null) q.offerLast(node.left);
                if (node.right != null) q.offerLast(node.right);
            }
            if (curr > high) {
                high = curr;
                level = currLevel;
            }
            currLevel++;
        }
        return level;
    }
}
