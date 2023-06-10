class Solution {
public:
    int longestSemiRepetitiveSubstring(string s) {
        int left = 0, doubleRight = 0, high = 1;
        bool found = false;
        for (int right = 1; right < s.length(); right++) {
            if (s[right] == s[right - 1]) {
                high = (found) ? max(high, right - left) : max(high, right - left + 1);
                left = doubleRight;
                doubleRight = right;
                found = true;
            } else {
                high = max(high, right - left + 1);
            }
        }
        return high;
    }
};
