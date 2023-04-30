class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        res, counter, curr = [], defaultdict(int), 0
        for x, y in zip(A, B):
            if counter[x] < 0: curr += 1
            counter[x] += 1
            if counter[y] > 0: curr += 1
            counter[y] -= 1
            res.append(curr)
        return res