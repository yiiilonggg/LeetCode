class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        left, doubleRight, high, found = 0, 0, 1, False
        for right in range(1, len(s)):
            if s[right] == s[right - 1]:
                high = max(high, right - left) if found else max(high, right - left + 1)
                left = doubleRight
                doubleRight = right
                found = True
            else:
                high = max(high, right - left + 1)
        return high
