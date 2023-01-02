import re

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        #return self.regexMethod(word)
        #return self.oneLiner(word)
        return self.algorithmMethod(word)

    def regexMethod(self, word):
        pattern = r'[A-Z]+|[a-z]+|[A-Z][a-z]+'
        return bool(re.fullmatch(pattern, word))

    def oneLiner(self, word):
        return word.isupper() or word.islower() or (word[0].isupper() and word[1:].islower())

    def algorithmMethod(self, word):
        mask = [w.isupper() for w in word]
        s, n = sum(mask), len(word)
        return s == 0 or s == n or (s == 1 and word[0].isupper())
