class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        res, left, right = 0, 0, len(nums) - 1
        while left < right:
            res += nums[left] * (10 ** self.findDigits(nums[right])) + nums[right]
            left += 1
            right -= 1
        if left == right: res += nums[left]
        return res

    def findDigits(self, x):
        d = 0
        while x > 0:
            x //= 10
            d += 1
        return d