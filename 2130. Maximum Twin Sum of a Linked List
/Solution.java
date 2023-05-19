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
class Solution {
    public int pairSum(ListNode head) {
        ListNode dummy = head, fast = head, slow = head;
        int halfn = 0, res = 0;
        while (dummy != null && dummy.next != null) {
            dummy = dummy.next.next;
            fast = fast.next;
            halfn++;
        }
        int[] v = new int[halfn];
        for (int i = 0; i < halfn; i++) {
            v[halfn - i - 1] += fast.val;
            v[i] += slow.val;
            fast = fast.next;
            slow = slow.next;
            res = Math.max(res, Math.max(v[halfn - i - 1], v[i]));
        }
        return res;
    }
}