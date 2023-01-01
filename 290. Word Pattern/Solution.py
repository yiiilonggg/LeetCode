class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words, letters = s.split(" "), [*pattern]
        if len(letters) != len(words) or len(set(letters)) != len(set(words)): return False
        seen = dict()
        n = len(letters)
        for i in range(n):
            if letters[i] in seen:
                if seen[letters[i]] != words[i]: return False
            else:
                seen[letters[i]] = words[i]
        return True
