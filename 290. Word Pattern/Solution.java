class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] letters = pattern.toCharArray();
        String[] words = s.split(" ");
        Set<Character> uniqueLetters = new HashSet<>();
        Set<String> uniqueWords = new HashSet<>();
        for (char l : letters) uniqueLetters.add(l);
        for (String w : words) uniqueWords.add(w);
        if (letters.length != words.length || uniqueLetters.size() != uniqueWords.size()) return false;
        int n = letters.length;
        Map<Character, String> seen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (seen.containsKey(letters[i])) {
                if (!seen.get(letters[i]).equals(words[i])) return false;
            } else {
                seen.put(letters[i], words[i]);
            }
        }
        return true;
    }
}
