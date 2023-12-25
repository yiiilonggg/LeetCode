class Solution {
public:
    int numDecodings(string s) {
        int l = s.length(), prev = 1, prevPrev = 0, curr;
        for (int i = 0; i < l; i++) {
            curr = (s[i] == '0') ? 0 : prev;
            if (i > 0 && s[i - 1] == '1') curr += prevPrev;
            if (i > 0 && s[i - 1] == '2' && s[i] <= '6') curr += prevPrev;
            prevPrev = prev;
            prev = curr;
        }
        return prev;
    }
};
