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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(), moreDummy = new ListNode();
        ListNode curr = head, currLess = lessDummy, currMore = moreDummy;
        while (curr != null) {
            ListNode foll = curr.next;
            if (curr.val < x) {
                currLess.next = curr;
                currLess = currLess.next;
            } else {
                currMore.next = curr;
                currMore = currMore.next;
            }
            curr.next = null;
            curr = foll;
        }
        currLess.next = moreDummy.next;
        return lessDummy.next;
    }
}
