class Solution:
    def minCost(self, nums: List[int], k: int) -> int:
        n = len(nums)
        trimmed = [[0 for i in range(n)] for j in range(n)]
        for i in range(n):
            freq = defaultdict(int)
            slide = 0
            for j in range(i, n):
                freq[nums[j]] += 1
                if freq[nums[j]] == 2:
                    slide += 2
                elif freq[nums[j]] > 2:
                    slide += 1
                trimmed[i][j] = slide
        dp = [0 for i in range(n + 1)]
        for i in range(1, n + 1):
            low = float('inf')
            for j in range(i):
                low = min(low, dp[j] + trimmed[j][i - 1] + k)
            dp[i] = low
        return dp[n]