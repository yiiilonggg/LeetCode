class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n, m = len(s1), len(s2)
        if m < n: return False
        freq = [0 for i in range(26)]
        for i in range(n):
            freq[self.getIdx(s1[i])] += 1
            freq[self.getIdx(s2[i])] -= 1
        if self.check(freq): return True
        for i in range(n, m):
            freq[self.getIdx(s2[i])] -= 1
            freq[self.getIdx(s2[i - n])] += 1
            if self.check(freq): return True
        return False

    def getIdx(self, c):
        return ord(c) - ord('a')

    def check(self, freq):
        for i in range(26):
            if freq[i] != 0: return False
        return True