class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        p = sorted(potions)
        n, m = len(spells), len(p)
        res = [0 for i in range(n)]
        for i in range(n):
            left, right = 0, m - 1
            while left < right:
                mid = (left + right) // 2
                if p[mid] * spells[i] < success:
                    left = mid + 1
                else:
                    right = mid
            res[i] = 0 if p[-1] * spells[i] < success else m - left
        return res