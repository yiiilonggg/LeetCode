# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import heapq
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        pq, q = [], [root]
        while q:
            l, total = len(q), 0
            for i in range(l):
                curr = q.pop(0)
                total += curr.val
                if curr.right: q.append(curr.right)
                if curr.left: q.append(curr.left)
            heapq.heappush(pq, -total)
        while pq and k > 1:
            heapq.heappop(pq)
            k -= 1
        return -1 if not pq else -heapq.heappop(pq)