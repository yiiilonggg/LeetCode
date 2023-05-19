# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        v = []
        curr = head
        while curr:
            v.append(curr.val)
            curr = curr.next
        n = len(v)
        v[k - 1], v[n - k] = v[n - k], v[k - 1]
        curr = head
        for i in range(n):
            curr.val = v[i]
            curr = curr.next
        return head