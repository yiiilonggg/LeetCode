class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        s = "{0:b}".format(n)
        even, odd, l, isEven = 0, 0, len(s), True
        for i in range(l - 1, -1, -1):
            if s[i] == '1':
                if isEven:
                    even += 1
                else:
                    odd += 1
            isEven = not isEven
        return [even, odd]
