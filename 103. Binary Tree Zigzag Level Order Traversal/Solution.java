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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        boolean startLeft = true;
        if (root != null) level.add(root);
        while (!level.isEmpty()) {
            List<Integer> nodeVals = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : level) {
                nodeVals.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            if (!startLeft) Collections.reverse(nodeVals);
            startLeft = !startLeft;
            res.add(nodeVals);
            level = nextLevel;
        }
        return res;
    }
}