class Solution {
    public int numDecodings(String s) {
        int prevPrev = 0, prev = 1;
        for (int i = 0; i < s.length(); i++) {
            int curr = (s.charAt(i) == '0') ? 0 : prev;
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i) < '7' && s.charAt(i - 1) == '2'))) curr += prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }
}
