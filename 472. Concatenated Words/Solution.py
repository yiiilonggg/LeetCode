class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        # return self.trieSolution(words)
        # return self.dfsSolution(words)
        return self.prefixSuffix(words)
        
    def trieSolution(self, word):
        root = Trie()
        for w in word: self.addWord(root, w)
        res = []
        for w in word:
            if self.testWord(w, root, 0, 0): res.append(w)
        return res

    def addWord(self, curr, w):
        for c in w:
            idx = ord(c) - ord('a')
            if curr.neighbours[idx] == None: curr.neighbours[idx] = Trie()
            curr = curr.neighbours[idx]
        curr.isEnd = True

    def testWord(self, w, root, curr, wordCount):
        pointer = root
        for i in range(curr, len(w)):
            idx = ord(w[i]) - ord('a')
            if pointer.neighbours[idx] == None: return False
            if pointer.neighbours[idx].isEnd:
                if i == len(w) - 1: return wordCount > 0
                if self.testWord(w, root, i + 1, wordCount + 1): return True
            pointer = pointer.neighbours[idx]
        return False
    
    def dfsSolution(self, words):
        seen = set(words)
        res = []
        for w in words:
            if self.dfs(seen, w, 0, 0): res.append(w)
        return res
    
    def dfs(self, seen, w, idx, wordCount):
        if idx == len(w): return wordCount > 1
        for i in range(idx, len(w)):
            sub = w[idx:i + 1]
            if sub in seen:
                if self.dfs(seen, w, i + 1, wordCount + 1): return True
        return False

    def prefixSuffix(self, words):
        seen = set(words)
        return [w for w in words if self.helper(seen, w)]
    
    def helper(self, seen, w):
        for i in range(1, len(w)):
            prefix, suffix = w[:i], w[i:]
            if prefix in seen and suffix in seen: return True
            if prefix in seen and self.helper(seen, suffix): return True
        return False

class Trie:
    def __init__(self):
        self.neighbours = [None for i in range(26)]
        self.isEnd = False