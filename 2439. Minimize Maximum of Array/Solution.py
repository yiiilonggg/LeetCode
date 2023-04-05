class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        left, right, n = 0, 1e9, len(nums)
        while left < right:
            mid, carry = (left + right) // 2, 0
            for i in range(n - 1, -1, -1):
                carry = max(0, carry + nums[i] - mid)
            if carry == 0:
                right = mid
            else:
                left = mid + 1
        return int(left)