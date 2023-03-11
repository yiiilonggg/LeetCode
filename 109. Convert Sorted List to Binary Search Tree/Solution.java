/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode root;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        this.root = head;
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        return build(0, n - 1);
    }
    public TreeNode build(int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode leftTree = build(left, mid - 1);
        TreeNode root = new TreeNode(this.root.val);
        this.root = this.root.next;
        root.left = leftTree;
        root.right = build(mid + 1, right);
        return root;
    }
}