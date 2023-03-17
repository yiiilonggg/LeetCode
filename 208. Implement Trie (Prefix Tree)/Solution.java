class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (curr.neighbours[c - 'a'] == null) curr.neighbours[c - 'a'] = new TrieNode();
            curr = curr.neighbours[c - 'a'];
        }
        curr.ends.add(word);
    }

    public TrieNode presearch(String s) {
        TrieNode curr = root;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (curr.neighbours[c - 'a'] == null) return null;
            curr = curr.neighbours[c - 'a'];
        }
        return curr;
    }
    
    public boolean search(String word) {
        TrieNode curr = presearch(word);
        return curr == null ? false : curr.ends.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        return presearch(prefix) != null;
    }
}

class TrieNode {
    TrieNode[] neighbours;
    Set<String> ends;
    public TrieNode() {
        neighbours = new TrieNode[26];
        ends = new HashSet<>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */