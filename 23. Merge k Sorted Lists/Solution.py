# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        i = 0
        for curr in lists:
            while curr != None:
                heapq.heappush(pq, (curr.val, i, curr))
                curr = curr.next
                i += 1
        if not pq: return None
        root = heapq.heappop(pq)[2]
        curr = root
        while pq:
            curr.next = heapq.heappop(pq)[2]
            curr = curr.next
        curr.next = None
        return root