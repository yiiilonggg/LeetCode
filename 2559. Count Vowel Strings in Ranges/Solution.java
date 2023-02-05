class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');
        int n = words.length, m = queries.length;
        int[] prefix = new int[n + 1], res = new int[m];
        for (int i = 0; i < n; i++) {
            int l = words[i].length();
            prefix[i + 1] = (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(l - 1))) ? prefix[i] + 1 : prefix[i];
        }
        for (int i = 0; i < m; i++) {
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return res;
    }
}