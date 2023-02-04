class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) return false;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        if (check(freq)) return true;
        for (int i = n; i < m; i++) {
            freq[s2.charAt(i) - 'a']--;
            freq[s2.charAt(i - n) - 'a']++;
            if (check(freq)) return true;
        }
        return false;
    }

    public boolean check(int[] freq) {
        int i;
        for (i = 0; i < 26 && freq[i] == 0; i++) { }
        return i == 26;
    }
}