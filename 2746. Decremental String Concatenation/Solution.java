class Solution {
    Map<Integer, Map<Character, Map<Character, Integer>>> cache = new HashMap<>();
    public int minimizeConcatenatedLength(String[] words) {
        return r(words, 1, words[0].charAt(0), words[0].charAt(words[0].length() - 1), words[0].length());
    }

    public int r(String[] words, int i, char first, char second, int l) {
        if (i == words.length) return l;
        if (cache.containsKey(i) && cache.get(i).containsKey(first) && cache.get(i).get(first).containsKey(second)) return cache.get(i).get(first).get(second) + l;
        int front = r(words, i + 1, first, words[i].charAt(words[i].length() - 1), (second == words[i].charAt(0)) ? l + words[i].length() - 1 : l + words[i].length());
        int back = r(words, i + 1, words[i].charAt(0), second, (first == words[i].charAt(words[i].length() - 1)) ? l + words[i].length() - 1 : l + words[i].length());
        if (!cache.containsKey(i)) cache.put(i, new HashMap<>());
        if (!cache.get(i).containsKey(first)) cache.get(i).put(first, new HashMap<>());
        cache.get(i).get(first).put(second, Math.min(front, back) - l);
        return Math.min(front, back);
    }
}
