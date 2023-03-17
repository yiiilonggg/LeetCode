class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if not curr.neighbours[ord(c) - 97]: curr.neighbours[ord(c) - 97] = TrieNode()
            curr = curr.neighbours[ord(c) - 97]
        curr.ends.add(word)

    def presearch(self, s):
        curr = self.root
        for c in s:
            if not curr.neighbours[ord(c) - 97]: return None
            curr = curr.neighbours[ord(c) - 97]
        return curr

    def search(self, word: str) -> bool:
        curr =  self.presearch(word)
        return False if not curr else word in curr.ends

    def startsWith(self, prefix: str) -> bool:
        return bool(self.presearch(prefix))
        
class TrieNode:
    def __init__(self):
        self.neighbours = [None for i in range(26)]
        self.ends = set()

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)