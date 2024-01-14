class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2): return False
        first, second = Counter(word1), Counter(word2)
        if set(first.keys()) != set(second.keys()): return False
        return Counter(first.values()) == Counter(second.values())
