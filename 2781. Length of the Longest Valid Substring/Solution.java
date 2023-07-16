class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Trie root = new Trie();
        for (String f : forbidden) root.insert(f);
        int n = word.length(), res = 0, right = n - 1;
        for (int left = n - 1; left >= 0; left--) {
            while (left <= right && root.search(word, left, right)) right--;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}

class Trie {
    Trie[] neighbours;
    boolean end;

    public Trie() {
        neighbours = new Trie[26];
        end = false;
    }

    public void insert(String w) {
        Trie curr = this;
        for (char c : w.toCharArray()) {
            if (curr.neighbours[c - 'a'] == null) curr.neighbours[c - 'a'] = new Trie();
            curr = curr.neighbours[c - 'a'];
        }
        curr.end = true;
    }

    public boolean search(String w, int left, int right) {
        Trie curr = this;
        for (int i = left; i <= right; i++) {
            if (curr.neighbours[w.charAt(i) - 'a'] == null) return false;
            curr = curr.neighbours[w.charAt(i) - 'a'];
            if (curr.end) return true;
        }
        return false;
    }
}
