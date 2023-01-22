class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.strs = []
        self.n = len(s)
        self.res = []
        self.backtrack(s, 0)
        return self.res

    def backtrack(self, s, start):
        if start == self.n:
            self.res.append([s for s in self.strs])
            return
        for i in range(start, self.n):
            if not self.check(s, start, i): continue
            self.strs.append(s[start:i + 1])
            self.backtrack(s, i + 1)
            self.strs.pop()
    
    def check(self, s, left, right):
        while left < right:
            if s[left] != s[right]: return False
            left += 1
            right -= 1
        return True