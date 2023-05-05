class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');
        int count = 0, n = s.length(), res = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) count++;
        }
        res = count;
        for (int i = k, j = 0; i < n; i++, j++) {
            if (vowels.contains(s.charAt(j))) count--;
            if (vowels.contains(s.charAt(i))) count++;
            res = Math.max(res, count);
        }
        return res;
    }
}