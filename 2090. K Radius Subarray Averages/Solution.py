class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = [-1 for i in range(n)]
        curr = sum(nums[:2 * k])
        for i in range(k, n - k):
            curr += nums[i + k]
            res[i] = curr // (2 * k + 1)
            curr -= nums[i - k]
        return res
