class Solution:
    def smallestBeautifulString(self, s: str, k: int) -> str:
        ch = [ord(c) - ord('a') for c in s]
        n, i = len(ch), len(ch) - 1
        while i >= 0:
            ch[i] += 1
            if ch[i] == k:
                i -= 1
            elif (i - 1 < 0 or ch[i - 1] != ch[i]) and (i - 2 < 0 or ch[i - 2] != ch[i]):
                for j in range(i + 1, n):
                    can = [True, True, True]
                    for k in range(max(0, j - 2), j):
                        if ch[k] > 2: continue
                        can[ch[k]] = False
                    for k in range(3):
                        if can[k]:
                            ch[j] = k
                            break
                return ''.join(chr(ord('a') + c) for c in ch)
        return ''