class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        m = len(cuts)
        cuts = [0] + sorted(cuts) + [n]
        dp = [[0 for i in range(m + 2)] for j in range(m + 2)]
        for diff in range(2, m + 2):
            for left in range(m + 2 - diff):
                right, curr = left + diff, 1e9
                for mid in range(left + 1, right):
                    curr = min(curr, dp[left][mid] + dp[mid][right] + cuts[right] - cuts[left])
                dp[left][right] = curr
        return dp[0][m + 1]

