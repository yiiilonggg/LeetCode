class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        for i in range(n - 1, -1, -1):
            curr = nums[i]
            while curr > 0:
                res.append(curr % 10)
                curr //= 10
        return res[::-1]