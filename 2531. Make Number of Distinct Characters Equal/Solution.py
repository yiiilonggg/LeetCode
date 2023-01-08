class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        n, m = len(word1), len(word2)
        first, second = [0 for i in range(26)], [0 for i in range(26)]
        for w in word1: first[ord(w) - ord('a')] += 1
        for w in word2: second[ord(w) - ord('a')] += 1
        for f in range(26):
            if first[f] == 0: continue
            for s in range(26):
                if second[s] == 0: continue
                self.swap(first, second, f, s)
                if self.equalDistinct(first, second): return True
                self.swap(first, second, s, f)
        return False

    def swap(self, first, second, f, s):
        first[f] -= 1
        second[s] -= 1
        first[s] += 1
        second[f] += 1

    def equalDistinct(self, first, second):
        firstCount, secondCount = 0, 0
        for i in range(26):
            if first[i] > 0: firstCount += 1
            if second[i] > 0: secondCount += 1
        return firstCount == secondCount