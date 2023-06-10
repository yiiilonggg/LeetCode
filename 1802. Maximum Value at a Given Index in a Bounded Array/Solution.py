class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        left, right = 1, maxSum
        while left < right:
            mid = (left + right + 1) // 2
            if self.s(index, mid, n) <= maxSum:
                left = mid
            else:
                right = mid - 1
        return left
    
    def s(self, idx, mid, n):
        res = 0
        if mid > idx:
            res += (mid + mid - idx) * (idx + 1) // 2
        else:
            res += (mid + 1) * mid // 2 + idx - mid + 1
        
        if mid >= n - idx:
            res += (mid + mid - n + 1 + idx) * (n - idx) // 2
        else:
            res += (mid + 1) * mid // 2 + n - idx - mid
        return res - mid
