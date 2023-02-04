class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1: return s
        n, step, pointer = len(s), 2 * numRows - 2, 0
        res = ['A' for i in range(n)]
        for i in range(0, n, step):
            res[pointer] = s[i]
            pointer += 1
        for i in range(1, numRows - 1):
            j = i
            odd = True
            while j < n:
                res[pointer] = s[j]
                pointer += 1
                j = j + step - i * 2 if odd else j + i * 2
                odd = not odd
        for i in range(numRows - 1, n, step):
            res[pointer] = s[i]
            pointer += 1
        return "".join(res)