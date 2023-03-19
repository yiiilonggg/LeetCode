class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        curr = self.root
        for c in word:
            if not curr.neighbours[ord(c) - 97]: curr.neighbours[ord(c) - 97] = TrieNode()
            curr = curr.neighbours[ord(c) - 97]
        curr.end = True

    def search(self, word: str) -> bool:
        return self.dfs(word, self.root, 0)
    
    def dfs(self, word, curr, i):
        if i == len(word): return curr.end
        if word[i] == '.':
            for n in curr.neighbours:
                if not n: continue
                if self.dfs(word, n, i + 1): return True
            return False
        else:
            if not curr.neighbours[ord(word[i]) - 97]: return False
            return self.dfs(word, curr.neighbours[ord(word[i]) - 97], i + 1)
        
class TrieNode:
    def __init__(self):
        self.end = False
        self.neighbours = [None for i in range(26)]

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)