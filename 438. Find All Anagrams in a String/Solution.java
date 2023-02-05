class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length(), n = s.length();
        List<Integer> res = new ArrayList<>();
        if (m > n) return res;
        int[] freq = new int[26];
        for (int i = 0; i < m; i++) {
            freq[p.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }
        if (check(freq)) res.add(0);
        for (int i = m; i < n; i++) {
            freq[s.charAt(i - m) - 'a']++;
            freq[s.charAt(i) - 'a']--;
            if (check(freq)) res.add(i - m + 1);
        }
        return res;
    }
    
    public boolean check(int[] freq) {
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }
}