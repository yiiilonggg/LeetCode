import heapq

class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        n, total, res = len(nums1), 0, -1
        combined = sorted(list(zip(nums1, nums2)), key = lambda x: (-x[1], -x[0]))
        q = []
        for i in range(n):
            total += combined[i][0]
            heapq.heappush(q, combined[i][0])
            if i >= k: total -= heapq.heappop(q)
            if i >= k - 1: res = max(res, total * combined[i][1])
        return res