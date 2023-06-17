class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        n, left, right = len(nums), 0, 0
        res = []
        while left < n and right < n:
            if right + 1 < n and nums[right] + 1 == nums[right + 1]:
                right += 1
            else:
                if right == left:
                    res.append(f"{nums[left]}")
                else:
                    res.append(f"{nums[left]}->{nums[right]}")
                left, right = right + 1, right + 1
        return res
