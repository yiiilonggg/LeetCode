class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        n = len(fruits)
        if n == 1: return 1
        dp = [0 for i in range(n)]
        dp[0], dp[1] = 1, 2
        first, second = fruits[0], fruits[1]
        for i in range(2, n):
            if fruits[i] == fruits[i - 1] or fruits[i] == first or fruits[i] == second:
                dp[i] = dp[i - 1] + 1
            else:
                first, second, pointer = fruits[i - 1], fruits[i], i - 1
                while pointer > 0 and fruits[pointer] == fruits[pointer - 1]: pointer -= 1
                dp[i] = i - pointer + 1
        return max(dp)