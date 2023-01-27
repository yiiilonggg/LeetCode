class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // return trieSolution(words);
        // return dfsSolution(words);
        return prefixSuffix(words);
    }

    public List<String> trieSolution(String[] words) {
        Trie root = new Trie();
        List<String> res = new ArrayList<>();
        for (String w : words) addWord(root, w);
        for (String w : words) {
            if (testWord(w.toCharArray(), root, 0, 0)) res.add(w);
        }
        return res;
    }

    public void addWord(Trie curr, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (curr.neighbours[s.charAt(i) - 'a'] == null) curr.neighbours[s.charAt(i) - 'a'] = new Trie();
            curr = curr.neighbours[s.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean testWord(char[] arr, Trie root, int curr, int wordCount) {
        Trie pointer = root;
        for (int i = curr; i < arr.length; i++) {
            if (pointer.neighbours[arr[curr] - 'a'] == null) return false;
            if (pointer.neighbours[arr[curr] - 'a'].isEnd) {
                if (curr == arr.length - 1) return wordCount > 0;
                if (testWord(arr, root, curr, wordCount + 1)) return true;;
                return false;
            }
            pointer = pointer.neighbours[arr[curr] - 'a'];
        } 
        return false;
    }

    public List<String> dfsSolution(String[] words) {
        Set<String> seen = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String w : words) seen.add(w);
        for (String w : words) {
            if (dfs(w, seen, 0, 0)) res.add(w);
        }
        return res;
    }

    public boolean dfs(String word, Set<String> seen, int idx, int wordCount) {
        if (idx == word.length()) return wordCount > 1;
        for (int i = idx; i < word.length(); i++) {
            String sub = word.substring(idx, i + 1);
            if (seen.contains(sub)) {
                if (dfs(word, seen, i + 1, wordCount + 1)) return true;
            }
        }
        return false;
    }

    public List<String> prefixSuffix(String[] words) {
        Set<String> seen = new HashSet<>();
        for (String w : words) seen.add(w);
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (helper(seen, w)) res.add(w);
        }
        return res;
    }

    public boolean helper(Set<String> seen, String w) {
        for (int i = 1; i < w.length(); i++) {
            String prefix = w.substring(0, i), suffix = w.substring(i);
            if (seen.contains(prefix) && seen.contains(suffix)) return true;
            if (seen.contains(prefix) && helper(seen, suffix)) return true;
        }
        return false;
    }
}

class Trie {
    Trie[] neighbours;
    boolean isEnd;
    public Trie() {
        this.neighbours = new Trie[26];
        this.isEnd = false;
    }
}