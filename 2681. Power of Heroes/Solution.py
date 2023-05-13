class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        nums = sorted(nums)
        n = len(nums)
        prefix, prefixPrefix = [0 for i in range(n)], [0 for i in range(n)]
        prefix[0] = nums[0] * 1
        mod = 1000000007
        res = (((1 * nums[0] * nums[0]) % mod) * (1 * prefix[0])) % mod
        for i in range(1, n):
            prefix[i] = (prefixPrefix[i - 2] + prefix[i - 1] + nums[i]) % mod if i > 0 else (prefix[i - 1] + nums[i]) % mod
            prefixPrefix[i - 1] = (prefixPrefix[i - 2] + prefix[i - 1]) % mod if i > 1 else prefix[i - 1]
            p = (((1 * nums[i] * nums[i]) % mod) * (1 * prefix[i])) % mod
            res = (res + p) % mod
        return res