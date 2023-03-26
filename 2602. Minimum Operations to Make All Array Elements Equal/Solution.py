import bisect

class Solution:
    def minOperations(self, nums: List[int], queries: List[int]) -> List[int]:
        nums = sorted(nums)
        res = []
        n = len(nums)
        prefix = [nums[0]]
        for i in range(1, n): prefix.append(prefix[-1] + nums[i])
        for q in queries:
            x = bisect.bisect_left(nums, q)
            if x < n and nums[x] == q:
                low = 0 if x == 0 else x * q - prefix[x - 1]
                high = 0 if x == n - 1 else (prefix[-1] - prefix[x]) - q * (n - x - 1)
                res.append(high + low)
            else:
                if x == 0:
                    res.append(prefix[-1] - n * q)
                elif x == n:
                    res.append(n * q - prefix[-1])
                else:
                    low = x * q - prefix[x - 1]
                    high = prefix[-1] - prefix[x - 1] - q * (n - x)
                    res.append(high + low)
        return res