class Solution {
    public boolean isItPossible(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] first = new int[26], second = new int[26];
        for (int i = 0; i < n; i++) first[word1.charAt(i) - 'a']++;
        for (int i = 0; i < m; i++) second[word2.charAt(i) - 'a']++;
        for (int f = 0; f < 26; f++) {
            if (first[f] == 0) continue;
            for (int s = 0; s < 26; s++) {
                if (second[s] == 0) continue;
                swap(first, second, f, s);
                if (equalDistinct(first, second)) return true;
                swap(first, second, s, f);
            }
        }
        return false;
    }
    private boolean equalDistinct(int[] first, int[] second) {
        int firstCount = 0, secondCount = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] > 0) firstCount++;
            if (second[i] > 0) secondCount++;
        }
        return firstCount == secondCount;
    }
    private void swap(int[] first, int[] second, int firstIndex, int secondIndex) {
        first[firstIndex]--;
        second[secondIndex]--;
        first[secondIndex]++;
        second[firstIndex]++;
    }
}