class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        m, n = len(s1), len(baseStr)
        letters = 'abcdefghijklmnopqrstuvwxyz'
        parents = dict([(letters[i], letters[i]) for i in range(26)])
        for i in range(m):
            self.union(parents, s1[i], s2[i])
        res = ""
        for i in range(n):
            res += self.find(parents, baseStr[i])
        return res
    
    def find(self, parents, i):
        while parents[i] != i: i = parents[i]
        return i
    
    def union(self, parents, first, second):
        x, y = self.find(parents, first), self.find(parents, second)
        if x < y:
            parents[y] = x
        else:
            parents[x] = y