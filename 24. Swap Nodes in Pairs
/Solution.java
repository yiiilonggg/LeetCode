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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head), prev = dummy, curr = head, foll = head;
        while (foll != null && foll.next != null) {
            foll = foll.next;
            prev.next = foll;
            curr.next = foll.next;
            foll.next = curr;
            prev = curr;
            curr = curr.next;
            foll = curr;
        }
        return dummy.next;
    }
}