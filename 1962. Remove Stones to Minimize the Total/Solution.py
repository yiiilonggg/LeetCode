class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        counts = [0 for i in range(10001)]
        for p in piles:
            counts[p] += 1
        for i in range(10000, 1, -1):
            if counts[i] == 0: continue
            counts[self.floor(i)] += min(k, counts[i])
            if k >= counts[i]:
                k -= counts[i]
                counts[i] = 0
            else:
                counts[i] -= k
                k = 0
            if k == 0: break
        return sum([i * counts[i] for i in range(10001)])

    def floor(self, x):
        return (x + 1) // 2
