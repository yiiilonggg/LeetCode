# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        dummy, fast, slow = head, head, head
        halfn, res = 0, 0
        while dummy and dummy.next:
            dummy, fast = dummy.next.next, fast.next
            halfn += 1
        v = [0 for i in range(halfn)]
        for i in range(halfn):
            v[-i - 1] += fast.val
            v[i] += slow.val
            fast, slow = fast.next, slow.next
            res = max(res, v[-i - 1], v[i])
        return res