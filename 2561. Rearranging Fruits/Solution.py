class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        A, B = Counter(basket1), Counter(basket2)
        for k, v in B.items():
            if k not in A:
                A[k] = -v
            else:
                A[k] -= v
        toSwap = []
        for k, v in A.items():
            if v % 2 != 0: return -1
            if v == 0: continue
            for i in range(abs(v) // 2): toSwap.append(k)
        low, cost, l = min(min(A.keys()), min(B.keys())), 0, len(toSwap)
        toSwap = sorted(toSwap)
        for i in range(l // 2):
            cost += min(low * 2, toSwap[i])
        return cost