class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        int n = vals.length, m = s.length(), res = 0, curr = 0;
        for (int i = 0; i < n; i++) map.put(chars.charAt(i), vals[i]);
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                curr += map.get(c);
            } else {
                curr += s.charAt(i) - 'a' + 1;
            }
            res = Math.max(res, curr);
            if (curr < 0) curr = 0;
        }
        return res;
    }
}