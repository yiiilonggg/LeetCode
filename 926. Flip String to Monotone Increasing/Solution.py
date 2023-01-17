class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        # return self.dp(s)
        return self.logic(s)

    def logic(self, s):
        zeros, onesToZeros = 0, 0
        for c in s:
            if c == '0':
                zeros += 1
            else:
                onesToZeros += 1
            zeros = min(zeros, onesToZeros)
        return zeros

    def dp(self, s):
        n, res = len(s), 100001
        oneToZeros, zeroToOnes = [0 for i in range(n + 1)], [0 for i in range(n + 1)]
        for i in range(n):
            oneToZeros[i + 1] = oneToZeros[i] + 1 if s[i] == '1' else oneToZeros[i]
            zeroToOnes[n - i - 1] = zeroToOnes[n - i] + 1 if s[n - i - 1] == '0' else zeroToOnes[n - i]
        for i in range(n):
            res = min(res, oneToZeros[i + 1] + zeroToOnes[i])
        return res - 1