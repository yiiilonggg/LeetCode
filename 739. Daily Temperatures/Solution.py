class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0 for i in range(n)]
        stack = []
        for i, curr in enumerate(temperatures):
            while stack and stack[-1][0] < curr:
                polled = stack.pop()
                res[polled[1]] = i - polled[1]
            stack.append([curr, i])
        return res
