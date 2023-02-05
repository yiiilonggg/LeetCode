class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        left, right = 1, 1e9
        while left < right:
            mid = (int) (left + right) // 2
            if self.check(nums, k, mid):
                right = mid
            else:
                left = mid + 1
        return left
    
    def check(self, nums, k, mid):
        i, n = 0, len(nums)
        while i < n and k > 0:
            if nums[i] <= mid:
                k -= 1
                i += 2
            else:
                i += 1
        return k == 0