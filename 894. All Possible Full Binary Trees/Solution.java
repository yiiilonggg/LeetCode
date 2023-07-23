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
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        List<TreeNode>[] dp = new List[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new ArrayList<>();
        dp[1].add(new TreeNode(0));
        for (int i = 3; i <= n; i += 2) {
            for (int j = 1; j < i; j += 2) {
                int k = i - j - 1;
                for (TreeNode left : dp[j]) {
                    for (TreeNode right : dp[k]) {
                        dp[i].add(new TreeNode(0, left, right));
                    }
                }
            }
        }
        return dp[n];
    }
}
