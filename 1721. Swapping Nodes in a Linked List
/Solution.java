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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> v = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            v.add(curr.val);
            curr = curr.next;
        }
        int n = v.size(), temp = v.get(k - 1);
        v.set(k - 1, v.get(n - k));
        v.set(n - k, temp);
        curr = head;
        for (int i = 0; i < n; i++, curr = curr.next) {
            curr.val = v.get(i);
        }
        return head;
    }
}