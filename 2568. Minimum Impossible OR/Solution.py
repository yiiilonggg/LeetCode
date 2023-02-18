class Solution:
    def minImpossibleOR(self, nums: List[int]) -> int:
        seen = set(nums)
        poll = 1
        while poll:
            if poll not in seen: return poll
            poll <<= 1
        return -1