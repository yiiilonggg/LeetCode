class Solution:
    def canSplitArray(self, nums: List[int], m: int) -> bool:
        if len(nums) <= 2: return True
        self.memo = set()
        return self.r(nums, 0, len(nums) - 1, sum(nums), m)
    
    def r(self, nums, left, right, s, m):
        if left >= right: return True
        if s < m: return False
        if (left, right) in self.memo: return False
        if self.r(nums, left + 1, right, s - nums[left], m) or self.r(nums, left, right - 1, s - nums[right], m):
            return True
        self.memo.add((left, right))
        return False
