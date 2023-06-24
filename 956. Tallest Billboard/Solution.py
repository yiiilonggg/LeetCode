class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        n = len(rods)
        first, second = self.split(rods[:n // 2]), self.split(rods[n // 2:])
        res = 0
        for diff in first:
            if -diff in second:
                res = max(res, first[diff] + second[-diff])
        return res

    def split(self, rods):
        states = set([(0, 0)])
        for r in rods:
            curr = set()
            for left, right in states:
                curr.add((left + r, right))
                curr.add((left, right + r))
            states |= curr
        dp = {}
        for left, right in states:
            dp[left - right] = max(dp.get(left - right, 0), left)
        return dp
