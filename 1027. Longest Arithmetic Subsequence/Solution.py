class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        n = len(nums)
        diffs = [dict() for i in range(n)]
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] - nums[j] in diffs[i]: continue
                diffs[i][nums[i] - nums[j]] = j
        high = 0
        for i in range(n):
            if i + high >= n: break
            for d, j in diffs[i].items():
                high = max(high, self.dfs(nums, diffs, j, d, 2))
        return high

    def dfs(self, nums, diffs, i, d, count):
        if i == len(nums): return count
        if d not in diffs[i].keys(): return count
        return self.dfs(nums, diffs, diffs[i][d], d, count + 1)
