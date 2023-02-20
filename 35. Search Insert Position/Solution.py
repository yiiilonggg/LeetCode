class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        # return bisect.bisect_left(nums, target)
        if target <= nums[0]: return 0
        if target > nums[-1]: return len(nums)
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target: return mid
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left