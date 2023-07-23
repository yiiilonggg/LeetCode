class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        n = len(nums)
        odd, even, curr = -float('inf'), -float('inf'), 0
        if nums[0] % 2 == 0:
            even = nums[0]
        else:
            odd = nums[0]
        for i in range(1, n):
            if nums[i] % 2 == 0:
                curr = max(even + nums[i], odd + nums[i] - x)
                even = max(even, curr)
            else:
                curr = max(odd + nums[i], even + nums[i] - x)
                odd = max(odd, curr)
        return max(even, odd)
