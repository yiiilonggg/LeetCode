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
    ListNode head;
    Random r;
    public Solution(ListNode head) {
        this.head = head;
        r = new Random();
    }
    
    public int getRandom() {
        ListNode curr = head;
        int res = head.val;
        for (int i = 1; curr.next != null; i++) {
            curr = curr.next;
            if (r.nextInt(i + 1) == i) res = curr.val;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */