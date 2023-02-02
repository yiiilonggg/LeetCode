class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ordering = new int[26];
        for (int i = 0; i < 26; i++) ordering[order.charAt(i) - 'a'] = i;
        int n = words.length;
        for (int i = 1; i < n; i++) {
            int a = words[i - 1].length(), b = words[i].length(), j;
            for (j = 0; j < Math.min(a, b); j++) {
                if (ordering[words[i].charAt(j) - 'a'] > ordering[words[i - 1].charAt(j) - 'a']) break;
                if (ordering[words[i].charAt(j) - 'a'] < ordering[words[i - 1].charAt(j) - 'a']) return false;
            }
            if (j == Math.min(a, b) && j < a) return false;
        }
        return true;
    }
}