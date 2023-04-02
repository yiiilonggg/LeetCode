class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        res, i, l = 0, 0, len(s)
        while i < l:
            while i < l and s[i] != '0': i += 1
            start = i
            while i < l and s[i] == '0': i += 1
            zeros = i - start
            while i < l and s[i] == '1': i += 1
            res = max(res, min(zeros, i - start - zeros) * 2)
        return res