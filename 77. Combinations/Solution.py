class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k == 0: return [[]]
        res = []
        for i in range(k, n + 1):
            for prev in self.combine(i - 1, k - 1):
                res.append(prev + [i])
        return res
