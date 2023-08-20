# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        lessDummy, moreDummy = ListNode(), ListNode()
        curr, currLess, currMore = head, lessDummy, moreDummy
        while curr:
            foll = curr.next
            if curr.val < x:
                currLess.next = curr
                currLess = currLess.next
            else:
                currMore.next = curr
                currMore = currMore.next
            curr.next = None
            curr = foll
        currLess.next = moreDummy.next
        return lessDummy.next
