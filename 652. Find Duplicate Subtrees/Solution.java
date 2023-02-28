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
    Map<TreeNode, String> hash;
    Map<String, Integer> seen;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hash = new HashMap<>();
        seen = new HashMap<>();
        res = new ArrayList<>();
        hashing(root);
        return res;
    }
    public void hashing(TreeNode curr) {
        StringBuilder str = new StringBuilder();
        str.append("*C");
        str.append(curr.val);
        if (curr.left != null || curr.right != null) {
            if (curr.left != null && !hash.containsKey(curr.left)) hashing(curr.left);
            if (curr.right != null && !hash.containsKey(curr.right)) hashing(curr.right);
            str.append(curr.left != null ? hash.get(curr.left) : "*L");
            str.append(curr.right != null ? hash.get(curr.right) : "*R");
        }
        String s = str.toString();
        if (seen.getOrDefault(s, 0) == 1) res.add(curr);
        seen.put(s, seen.getOrDefault(s, 0) + 1);
        hash.put(curr, s);
    }
}