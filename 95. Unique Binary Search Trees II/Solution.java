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
    Map<Integer, Map<Integer, List<TreeNode>>> memo = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        return r(1, n);
    }
    public List<TreeNode> r(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        if (left == right) {
            res.add(new TreeNode(left));
            return res;
        }
        if (memo.containsKey(left) && memo.get(left).containsKey(right)) return memo.get(left).get(right);
        for (int i = left; i < right + 1; i++) {
            for (TreeNode l : r(left, i - 1)) {
                for (TreeNode r : r(i + 1, right)) {
                    res.add(new TreeNode(i, l, r));
                }
            }
        }
        if (!memo.containsKey(left)) memo.put(left, new HashMap<>());
        memo.get(left).put(right, res);
        return res;
    }
}
