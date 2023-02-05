class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        ban = set(banned)
        sum, count = 0, 0
        for i in range(1, n + 1):
            if i in ban: continue
            sum += i
            if sum <= maxSum:
                count += 1
            else:
                break
        return count