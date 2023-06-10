class Solution:
    def sumDistance(self, nums: List[int], s: str, d: int) -> int:
        n, MOD, res = len(s), 1000000007, 0
        a = sorted([nums[i] + d if s[i] == 'R' else nums[i] - d for i in range(n)])
        prev, prefix = a[0], 0
        for i in range(1, n):
            res = (res + prefix + i * abs(a[i] - prev)) % MOD
            prefix = (prefix + i * abs(a[i] - prev)) % MOD
            prev = a[i]
        return res
