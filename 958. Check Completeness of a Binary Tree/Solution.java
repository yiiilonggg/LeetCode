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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                TreeNode curr = q.poll();
                if (curr.left == null) {
                    flag = true;
                } else {
                    if (flag) return false;
                    q.offer(curr.left);
                }
                if (curr.right == null) {
                    flag = true;
                } else {
                    if (flag) return false;
                    q.offer(curr.right);
                }
            }
        }
        return true;
    }
}