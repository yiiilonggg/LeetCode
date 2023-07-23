class Solution:
    def maxIncreasingGroups(self, usageLimits: List[int]) -> int:
        u = sorted(usageLimits)
        left, right = 0, len(u)
        while left < right:
            mid = (left + right) // 2
            if self.check(u, mid):
                left = mid + 1
            else:
                right = mid - 1
        return left if self.check(u, left) else left - 1

    def check(self, arr, x):
        curr, i, surp = 1, 0, 0
        while curr <= x:
            if i == len(arr): break
            if arr[i] >= curr:
                surp += arr[i] - curr
                i += 1
                curr += 1
            else:
                if surp + arr[i] >= curr:
                    surp -= curr - arr[i]
                    curr += 1
                    i += 1
                    continue
                while i < len(arr) and surp < curr:
                    surp += arr[i]
                    i += 1
                if surp >= curr:
                    surp -= curr
                    curr += 1
                else:
                    return False
        return curr > x
