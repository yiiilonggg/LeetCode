class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        n, r = len(word), 0
        res = [0 for i in range(n)]
        for i in range(n):
            r = (r * 10 + int(word[i])) % m
            if r == 0: res[i] = 1
        return res