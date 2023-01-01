class Solution:
    def minimumPartition(self, s: str, k: int) -> int:
        if k < 10: return -1 if int(max(s)) > k else len(s)
        curr, res = "", 0
        for w in s:
            if int(curr + w) < k:
                curr += w
            else:
                if not curr: return -1
                res += 1
                curr = w
        return res + 1
