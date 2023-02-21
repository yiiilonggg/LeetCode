class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return nums[0]
        left, right = 0, n - 1
        while (left < right):
            mid = (left + right) // 2
            if mid % 2 == 1: mid -= 1
            if nums[mid] != nums[mid + 1]:
                right = mid
            else:
                left = mid + 2
        return nums[left]