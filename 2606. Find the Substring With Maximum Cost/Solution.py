class Solution:
    def maximumCostSubstring(self, s: str, chars: str, vals: List[int]) -> int:
        m = dict(zip(chars, vals))
        curr, res = 0, 0
        for c in s:
            if c in m:
                curr += m[c]
            else:
                curr += ord(c) - ord('a') + 1
            res = max(res, curr)
            curr = max(curr, 0)
        return res