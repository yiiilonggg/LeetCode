class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        if p == 0: return 0
        nums = sorted(nums)
        n, left, right = len(nums), 0, nums[-1] - nums[0]
        while left < right:
            mid, curr, i = (left + right) // 2, 0, 1
            while i < n and curr < p:
                if nums[i] - nums[i - 1] <= mid:
                    curr += 1
                    i += 1
                i += 1
            if curr == p:
                right = mid
            else:
                left = mid + 1
        return left