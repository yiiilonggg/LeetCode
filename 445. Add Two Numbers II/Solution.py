# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        rfirst, rsecond = self.reverse(l1), self.reverse(l2)
        cfirst, csecond = rfirst, rsecond
        pfirst, psecond = None, None
        carry = 0
        while cfirst and csecond:
            val = cfirst.val + csecond.val + carry
            carry = 1 if val > 9 else 0
            cfirst.val = val % 10
            pfirst, psecond = cfirst, csecond
            cfirst, csecond = cfirst.next, csecond.next
        if not cfirst and csecond:
            pfirst.next = csecond
            cfirst = csecond
        while cfirst or carry:
            if not cfirst:
                cfirst = ListNode()
                pfirst.next = cfirst
            val = cfirst.val + carry
            carry = 1 if val > 9 else 0
            cfirst.val = val % 10
            pfirst = cfirst
            cfirst = cfirst.next
        return self.reverse(rfirst)

    def reverse(self, root):
        prev, curr, foll = None, root, root
        while curr:
            foll = foll.next
            curr.next = prev
            prev = curr
            curr = foll
        return prev
