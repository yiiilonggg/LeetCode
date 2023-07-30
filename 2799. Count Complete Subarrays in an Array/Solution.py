class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        self.res = 0
        self.n = len(set(nums))
        if self.n == 1: return len(nums) * (len(nums) + 1) // 2
        if self.n == len(nums): return 1
        self.counter = dict()
        self.seen = set()
        for num in nums:
            self.counter[num] = 1 if num not in self.counter else self.counter[num] + 1
        self.count(nums, 0, len(nums) - 1)
        return self.res
        
    def count(self, nums, left, right):
        if left > right: return
        if (left, right) in self.seen: return
        self.seen.add((left, right))
        if len(self.counter) < self.n: return
        self.res += 1
        self.counter[nums[left]] -= 1
        if self.counter[nums[left]] == 0: del self.counter[nums[left]]
        self.count(nums, left + 1, right)
        self.counter[nums[left]] = 1 if nums[left] not in self.counter else self.counter[nums[left]] + 1
        self.counter[nums[right]] -= 1
        if self.counter[nums[right]] == 0: del self.counter[nums[right]]
        self.count(nums, left, right - 1)
        self.counter[nums[right]] = 1 if nums[right] not in self.counter else self.counter[nums[right]] + 1
