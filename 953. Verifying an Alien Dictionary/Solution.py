class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        ordering = dict([[order[i], i] for i in range(26)])
        n = len(words)
        for i in range(1, n):
            a, b, j = len(words[i - 1]), len(words[i]), 0
            while j < min(a, b):
                if ordering[words[i][j]] > ordering[words[i - 1][j]]: break
                if ordering[words[i][j]] < ordering[words[i - 1][j]]: return False
                j += 1
            if j == min(a, b) and j < a: return False
        return True