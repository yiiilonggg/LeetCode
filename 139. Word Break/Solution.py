class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.memo = set()
        return self.r(s, set(wordDict), 0)
    def r(self, s, d, i):
        if i == len(s): return True
        if i in self.memo: return False
        for j in range(i + 1, len(s) + 1):
            if s[i:j] in d and self.r(s, d, j): return True
        self.memo.add(i)
        return False
