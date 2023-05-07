class Solution:
    def distinctDifferenceArray(self, nums: List[int]) -> List[int]:
        n, p, s = len(nums), 0, 0
        prefix, suffix, res = [0 for i in range(51)], [0 for i in range(51)], [0 for i in range(n)]
        for i in range(n):
            suffix[nums[i]] += 1
            if suffix[nums[i]] == 1: s += 1
        for i in range(n):
            suffix[nums[i]] -= 1
            prefix[nums[i]] += 1
            if suffix[nums[i]] == 0: s -= 1
            if prefix[nums[i]] == 1: p += 1
            res[i] = p - s
        return res 