class Solution:
    def alternatingSubarray(self, nums: List[int]) -> int:
        n, high, left, right = len(nums), 0, 0, 1
        while right < n:
            while right < n and nums[right] != nums[right - 1] + 1:
                right += 1
            if right == n: break
            left = right - 1
            x, y = nums[left], nums[right]
            alt = False
            while right < n:
                if (alt and nums[right] != x) or (not alt and nums[right] != y): break
                right += 1
                alt = not alt
            high = max(high, right - left)
        return high if high > 0 else -1
