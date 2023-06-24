class Solution:
    def minimizeConcatenatedLength(self, words: List[str]) -> int:
        self.cache = dict()
        return self.r(words, 1, words[0][0], words[0][-1], len(words[0]))
                
    def r(self, words, i, first, last, l):
        if i == len(words): return l
        if (i, first, last) in self.cache: return l + self.cache[(i, first, last)]
        left = self.r(words, i + 1, first, words[i][-1], l + len(words[i]) - 1 if last == words[i][0] else l + len(words[i]))
        right = self.r(words, i + 1, words[i][0], last, l + len(words[i]) - 1 if first == words[i][-1] else l + len(words[i]))
        self.cache[(i, first, last)] = min(left, right) - l
        return min(left, right)
