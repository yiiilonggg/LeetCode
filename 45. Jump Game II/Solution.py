class Solution:
    def jump(self, nums: List[int]) -> int:
        n, curr, high, count = len(nums), 0, 0, 0
        while high < n - 1:
            nextCurr, nextHigh = curr, high
            for i in range(curr, high + 1):
                if i + nums[i] > nextHigh:
                    nextHigh, nextCurr = i + nums[i], i
            high, curr = nextHigh, nextCurr
            count += 1
        return count