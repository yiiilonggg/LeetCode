class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:
        return sum([self.backtrack(nums, k, i, set()) for i in range(len(nums))])
    def backtrack(self, nums, k, i, seen):
        if i == len(nums): return 0
        total = 1
        seen.add(nums[i])
        for j in range(i + 1, len(nums)):
            if nums[j] - k in seen or nums[j] + k in seen: continue
            total += self.backtrack(nums, k, j, seen)
        seen.discard(nums[i])
        return total