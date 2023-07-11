/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return res;
    }

    public int dfs(TreeNode curr, TreeNode target, int k) {
        if (curr == null) return -1;
        if (curr.val == target.val) {
            dfs2(curr, 0, k);
            return 1;
        } else {
            int a = dfs(curr.left, target, k);
            int b = dfs(curr.right, target, k);
            if (a >= 0) {
                if (a == k) res.add(curr.val);
                dfs2(curr.right, a + 1, k);
                return a + 1;
            }
            if (b >= 0) {
                if (b == k) res.add(curr.val);
                dfs2(curr.left, b + 1, k);
                return b + 1;
            }
            return -1;
        }
    }

    public void dfs2(TreeNode curr, int depth, int k) {
        if (curr == null) return;
        if (depth > k) return;
        if (depth == k) {
            res.add(curr.val);
            return;
        }
        dfs2(curr.left, depth + 1, k);
        dfs2(curr.right, depth + 1, k);
    }
}
