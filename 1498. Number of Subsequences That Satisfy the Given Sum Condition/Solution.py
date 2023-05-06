class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        res, mod, left, right = 0, 1000000007, 0, len(nums) - 1
        power = [1 << i for i in range(len(nums))]
        while left <= right:
            if nums[left] + nums[right] > target:
                right -= 1
            else:
                res = (res + power[right - left]) % mod
                left += 1
        return res
