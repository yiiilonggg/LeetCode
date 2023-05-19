# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(next = head)
        prev, curr, foll = dummy, head, head
        while foll and foll.next:
            foll = foll.next
            prev.next = foll
            curr.next = foll.next
            foll.next = curr
            prev, curr, foll = curr, curr.next, curr.next
        return dummy.next