class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        s = sorted(satisfaction, reverse = True)
        prefix, total = 0, 0
        for i in s:
            prefix += i
            if prefix < 0: break
            total += prefix
        return total