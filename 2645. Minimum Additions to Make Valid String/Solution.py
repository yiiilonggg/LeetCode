class Solution:
    def addMinimum(self, word: str) -> int:
        res, curr = 0, 0
        for c in word:
            while ord(c) - ord('a') != curr:
                res += 1
                curr = (curr + 1) % 3
            curr = (curr + 1) % 3
        while curr != 0:
            res += 1
            curr = (curr + 1) % 3
        return res