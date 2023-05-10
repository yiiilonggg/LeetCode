class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        curr = 1
        res = [[0 for i in range(n)] for j in range(n)]
        for layer in range(n // 2 + 1):
            for i in range(layer, n - layer):
                res[layer][i] = curr
                curr += 1
            for i in range(layer + 1, n - layer):
                res[i][n - layer - 1] = curr
                curr += 1
            for i in range(n - layer - 2, layer - 1, -1):
                res[n - layer - 1][i] = curr
                curr += 1
            for i in range(n - layer - 2, layer, -1):
                res[i][layer] = curr
                curr += 1
        return res