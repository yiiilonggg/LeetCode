class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        trie = Trie()
        for w in forbidden: trie.insert(w)
        n, res, right = len(word), 0, len(word) - 1
        for left in range(n - 1, -1, -1):
            while left <= right and trie.search(word, left, right): right -= 1
            res = max(res, right - left + 1)
        return res

class Trie:
    def __init__(self):
        self.neighbours = [None for i in range(26)]
        self.end = False
    
    def insert(self, word):
        curr = self
        for c in word:
            if not curr.neighbours[ord(c) - ord('a')]: curr.neighbours[ord(c) - ord('a')] = Trie()
            curr = curr.neighbours[ord(c) - ord('a')]
        curr.end = True
    
    def search(self, word, left, right):
        curr = self
        for i in range(left, right + 1):
            if not curr.neighbours[ord(word[i]) - ord('a')]: return False
            curr = curr.neighbours[ord(word[i]) - ord('a')]
            if curr.end: return True
        return False
