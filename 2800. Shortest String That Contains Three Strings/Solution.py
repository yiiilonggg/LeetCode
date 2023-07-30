class Solution:
    def minimumString(self, a: str, b: str, c: str) -> str:
        self.memo = dict()
        res = a + b + c
        for i in range(3):
            first, second = self.overlap(self.overlap(a, b), c), self.overlap(self.overlap(a, c), b)
            if len(first) < len(res) or (len(first) == len(res) and first < res): res = first
            if len(second) < len(res) or (len(second) == len(res) and second < res): res = second
            a, b, c = b, c, a
        return res
        
    def overlap(self, x, y):
        if (x, y) not in self.memo:
            if y in x:
                self.memo[(x, y)] = x
            else:
                m, n = len(x), len(y)
                overlap = -1
                for i in range(n, 0, -1):
                    if i > len(x): continue
                    if y[:i] == x[m - i:]:
                        overlap = i
                        break
                if overlap == -1:
                    self.memo[(x, y)] = x + y
                else:
                    self.memo[(x, y)] = x + y[overlap:]
        return self.memo[(x, y)]
            
