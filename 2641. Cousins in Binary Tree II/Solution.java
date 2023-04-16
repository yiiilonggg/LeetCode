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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Pair> pass = new LinkedList<>();
        q.offer(root);
        pass.offer(new Pair(root, root.val));
        int prevSum = 0, prevL = 0;
        while (!pass.isEmpty()) {
            int currSum = 0, l = q.size();
            for (int i = 0; i < l; i++) {
                TreeNode curr = q.poll();
                currSum += curr.val;
                int t = 0;
                if (curr.left != null) t += curr.left.val;
                if (curr.right != null) t += curr.right.val;
                if (curr.left != null) {
                    pass.offer(new Pair(curr.left, t));
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    pass.offer(new Pair(curr.right, t));
                    q.offer(curr.right);
                }
            }
            for (int i = 0; i < prevL; i++) {
                Pair curr = pass.poll();
                curr.node.val = prevSum - curr.s;    
            }
            prevSum = currSum;
            prevL = l;
        }
        return root;
    }
}
class Pair {
    TreeNode node;
    int s;
    public Pair(TreeNode c, int t) {
        node = c;
        s = t;
    }
}