# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head
        while fast != None and fast.next != None:
            slow, fast = slow.next, fast.next.next
            if slow == fast: break
        if fast == None or fast.next == None: return None
        while head != slow:
            head, slow = head.next, slow.next
        return head