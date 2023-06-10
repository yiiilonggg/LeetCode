class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int left = 0, doubleRight = 0, high = 1;
        boolean found = false;
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                high = (found) ? Math.max(high, right - left) : Math.max(high, right - left + 1);
                left = doubleRight;
                doubleRight = right;
                found = true;
            } else {
                high = Math.max(high, right - left + 1);
            }
        }
        return high;
    }
}
