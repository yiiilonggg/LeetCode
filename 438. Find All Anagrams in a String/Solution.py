class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        m, n = len(p), len(s)
        res = []
        if m > n: return res
        freq = [0 for i in range(26)]
        for i in range(m):
            freq[self.getIdx(p[i])] += 1
            freq[self.getIdx(s[i])] -= 1
        if self.check(freq): res.append(0)
        for i in range(m, n):
            freq[self.getIdx(s[i - m])] += 1
            freq[self.getIdx(s[i])] -= 1
            if self.check(freq): res.append(i - m + 1)
        return res
    
    def getIdx(self, c):
        return ord(c) - ord('a')
    
    def check(self, freq):
        for f in freq:
            if f != 0: return False
        return True