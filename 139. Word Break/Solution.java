class Solution {
    Set<Integer> memo = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> d = new HashSet<>(wordDict);
        return r(s, d, 0);
    }

    public boolean r(String s, Set<String> d, int i) {
        if (i == s.length()) return true;
        if (memo.contains(i)) return false;
        for (int j = i + 1; j < s.length() + 1; j++) {
            if (d.contains(s.substring(i, j)) && r(s, d, j)) return true;
        }
        memo.add(i);
        return false;
    }
}
