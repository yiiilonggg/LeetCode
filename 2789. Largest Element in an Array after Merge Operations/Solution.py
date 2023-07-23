class Solution:
    def maxArrayValue(self, nums: List[int]) -> int:
        n, high, curr = len(nums), 0, 0
        for i in range(n - 1, -1, -1):
            curr += nums[i]
            if i == 0 or nums[i] < nums[i - 1]:
                high = max(curr, high)
                if i > 0 and curr < nums[i - 1]: curr = 0
        return high
