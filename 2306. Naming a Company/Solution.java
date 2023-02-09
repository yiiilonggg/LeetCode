class Solution {
    public long distinctNames(String[] ideas) {
        long res = 0;
        Set<String>[] suffixes = new Set[26];
        for (int i = 0; i < 26; i++) suffixes[i] = new HashSet<>();
        for (String idea : ideas) suffixes[idea.charAt(0) - 'a'].add(idea.substring(1));
        int[][] same = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (String s : suffixes[i]) {
                for (int j = i + 1; j < 26; j++) {
                    if (suffixes[j].contains(s)) same[i][j]++;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                res += (suffixes[i].size() - same[i][j]) * (suffixes[j].size() - same[i][j]) * 2;
            }
        }
        return res;
    }
}