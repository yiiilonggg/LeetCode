class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        d, x, high, n = dict(), 0, 0, len(nums)
        for num in nums:
            d[num] = 1 if num not in d else d[num] + 1
            if d[num] > high:
                high, x = d[num], num
        left, right = 0, high
        for i in range(len(nums) - 1):
            if nums[i] == x:
                left += 1
                right -= 1
            if left > (i + 1) // 2 and right > (n - i - 1) // 2: return i
        return -1
