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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rfirst = reverse(l1), rsecond = reverse(l2);
        ListNode pfirst = null, psecond = null;
        ListNode cfirst = rfirst, csecond = rsecond;
        int carry = 0, val = 0;
        while (cfirst != null && csecond != null) {
            val = cfirst.val + csecond.val + carry;
            carry = (val > 9) ? 1 : 0;
            cfirst.val = val % 10;
            pfirst = cfirst;
            psecond = csecond;
            cfirst = cfirst.next;
            csecond = csecond.next;
        }
        if (cfirst == null && csecond != null) {
            pfirst.next = csecond;
            cfirst = csecond;
        }
        while (cfirst != null || carry > 0) {
            if (cfirst == null) {
                pfirst.next = new ListNode();
                cfirst = pfirst.next;
            }
            val = cfirst.val + carry;
            carry = (val > 9) ? 1 : 0;
            cfirst.val = val % 10;
            pfirst = cfirst;
            cfirst = cfirst.next;
        }
        return reverse(rfirst);
    }

    public ListNode reverse(ListNode root) {
        ListNode prev = null, curr = root, foll = root;
        while (curr != null) {
            foll = foll.next;
            curr.next = prev;
            prev = curr;
            curr = foll;
        }
        return prev;
    }
}
