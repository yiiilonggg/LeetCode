class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        seen, bucket, res = dict(), [[] for i in range(n + 1)], []
        for num in nums:
            if num not in seen: seen[num] = 0
            seen[num] += 1
        for key, val in seen.items():
            bucket[val].append(key)
        for i in range(n, -1, -1):
            if bucket[i]: res.extend(bucket[i])
            k -= len(bucket[i])
            if k == 0: break
        return res
