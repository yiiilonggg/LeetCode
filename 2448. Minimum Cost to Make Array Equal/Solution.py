class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        s = sorted(list(zip(nums, cost)), key = itemgetter(0))
        n = len(s)
        front, back = [0 for i in range(n)], [0 for i in range(n)]
        frontm, backm = s[0][1], s[-1][1]
        for i in range(1, n):
            front[i] = (s[i][0] - s[i - 1][0]) * frontm + front[i - 1]
            back[n - i - 1] = (s[n - i][0] - s[n - i - 1][0]) * backm + back[n - i]
            frontm += s[i][1]
            backm += s[n - i - 1][1]
        return min([front[i] + back[i] for i in range(n)])
