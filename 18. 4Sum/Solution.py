class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        self.res = []
        self.findSum(sorted(nums), 0, [], target, 4)
        return self.res
    
    def findSum(self, nums, curr, currList, target, N):
        if N < 2 or target < nums[curr] * N or target > nums[-1] * N: return
        if N == 2:
            left, right = curr, len(nums) - 1
            while left < right:
                if nums[left] + nums[right] == target:
                    self.res.append(currList + [nums[left], nums[right]])
                    left += 1
                    while left < right and nums[left - 1] == nums[left]: left += 1
                elif nums[left] + nums[right] < target:
                    left += 1
                else:
                    right -= 1
        else:
            for i in range(curr, len(nums) - N + 1):
                if i > curr and nums[i] == nums[i - 1]: continue
                self.findSum(nums, i + 1, currList + [nums[i]], target - nums[i], N - 1)