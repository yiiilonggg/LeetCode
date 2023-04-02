class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0, i = 0, l = s.length();
        while (i < l) {
            while (i < l && s.charAt(i) != '0') i++;
            int start = i;
            while (i < l && s.charAt(i) == '0') i++;
            int zeros = i - start;
            while (i < l && s.charAt(i) == '1') i++;
            int ones = i - start - zeros;
            res = Math.max(res, 2 * Math.min(zeros, ones));
        }
        return res;
    }
}