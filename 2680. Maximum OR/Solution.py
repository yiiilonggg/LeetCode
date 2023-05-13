class Solution:
    def maximumOr(self, nums: List[int], k: int) -> int:
        if len(nums) == 1: return nums[0] << k
        high, res = 0, 0
        p = []
        bits = [0 for i in range(32)]
        for n in nums:
            i = 0
            while (1 << i) <= n:
                if ((1 << i) & n) > 0: bits[i] += 1
                i += 1
            if i > high:
                p = [n]
                high = i
            elif i == high:
                p.append(n)
        for q in p:
            r = q << k
            for i in range(32):
                if bits[i] == 0 or ((1 << i) & r) > 0: continue
                if ((1 << i) & q) > 0 and bits[i] == 1: continue
                r |= (1 << i)
            res = max(res, r)
        return res