import heapq

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        n, m = len(nums1), len(nums2)
        pq = [(nums1[0] + nums2[0], 0, 0)]
        res = []
        seen = set((0, 0))
        while pq and k > 0:
            curr, left, right = heappop(pq)
            res.append([nums1[left], nums2[right]])
            k -= 1
            if left < n - 1 and (left + 1, right) not in seen:
                heappush(pq, (nums1[left + 1] + nums2[right], left + 1, right))
                seen.add((left + 1, right))
            if right < m - 1 and (left, right + 1) not in seen:
                heappush(pq, (nums1[left] + nums2[right + 1], left, right + 1))
                seen.add((left, right + 1))
        return res
