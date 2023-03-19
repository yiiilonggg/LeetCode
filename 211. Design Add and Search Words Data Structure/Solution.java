class WordDictionary {

    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (curr.neighbours[c - 'a'] == null) curr.neighbours[c - 'a'] = new TrieNode();
            curr = curr.neighbours[c - 'a'];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word.toCharArray(), 0);
    }

    public boolean dfs(TrieNode curr, char[] arr, int i) {
        if (i == arr.length) return curr.end;
        if (arr[i] == '.') {
            for (TrieNode n : curr.neighbours) {
                if (n == null) continue;
                if (dfs(n, arr, i + 1)) return true;
            }
            return false;
        } else {
            if (curr.neighbours[arr[i] - 'a'] == null) return false;
            return dfs(curr.neighbours[arr[i] - 'a'], arr, i + 1);
        }
    }
}

class TrieNode {
    TrieNode[] neighbours;
    boolean end;
    public TrieNode() {
        neighbours = new TrieNode[26];
        end = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */