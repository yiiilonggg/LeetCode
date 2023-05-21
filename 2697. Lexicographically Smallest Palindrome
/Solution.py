class Solution:
    def makeSmallestPalindrome(self, s: str) -> str:
        ch = [*s]
        n = len(ch)
        for i in range(n // 2):
            ch[i], ch[n - i - 1] = min(ch[i], ch[n - i - 1]), min(ch[i], ch[n - i - 1])
        return "".join(ch)
