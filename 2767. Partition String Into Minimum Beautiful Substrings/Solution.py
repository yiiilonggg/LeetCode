class Solution:
    def minimumBeautifulSubstrings(self, s: str) -> int:
        self.low = 16
        self.r(s, 0, "", 0)
        return self.low if self.low < 16 else -1
        
    def r(self, s, curr, x, count):
        if curr == len(s):
            if not x:
                self.low = min(self.low, count)
            else:
                if int(x, 2) == 0: return
                if int(x, 2) == 1 or self.check(int(x, 2)):
                    self.low = min(self.low, count + 1)
            return
        if not x and s[curr] == '0': return
        if (not x and s[curr] == '1') or (x and self.check(int(x + s[curr], 2))): self.r(s, curr + 1, "", count + 1)
        self.r(s, curr + 1, x + s[curr], count)
    
    def check(self, x):
        if x == 0: return False
        while x > 1:
            if x % 5 != 0: return False
            x //= 5
        return True
        
