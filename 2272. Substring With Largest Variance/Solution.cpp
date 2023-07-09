class Solution {
public:
    int largestVariance(string s) {
        int high = 0;
        string ch = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                char a = ch[i], b = ch[j];
                int curr = 0, currHigh = 0, currLow = 0, prevHigh = 0, prevLow = 0;
                bool hasA = false, hasB = false;
                for (char c : s) {
                    if (c == a) {
                        hasA = true;
                        curr++;
                        currHigh = max(currHigh, prevHigh);
                        prevHigh = curr;
                    } else if (c == b) {
                        hasB = true;
                        curr--;
                        currLow = min(currLow, prevLow);
                        prevLow = curr;
                    }
                    if (hasA && hasB) high = max(high, max(curr - currLow, currHigh - curr));
                }
            }
        }
        return high;
    }
};
