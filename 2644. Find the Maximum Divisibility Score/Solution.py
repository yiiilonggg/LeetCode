class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        high, res = 0, 1e9 + 1
        for d in divisors:
            curr = 0
            for n in nums:
                if n % d == 0: curr += 1
            if curr > high:
                res = d
                high = curr
            elif curr == high:
                res = min(d, res)
        return res