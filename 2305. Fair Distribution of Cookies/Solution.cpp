class Solution {
public:
    int low = 0;
    int distributeCookies(vector<int>& cookies, int k) {
        for (int c : cookies) low += c;
        r(cookies, k, 0, vector<int>(k, 0), k, 0);
        return low;
    }
    void r(vector<int>& cookies, int k, int curr, vector<int> kids, int zero, int high) {
        if (cookies.size() - curr < zero) return;
        if (curr == cookies.size()) {
            low = min(low, high);
            return;
        }
        if (high > low) return;
        for (int i = 0; i < k; i++) {
            zero -= (kids[i] == 0) ? 1 : 0;
            kids[i] += cookies[curr];
            int currHigh = max(high, kids[i]);
            r(cookies, k, curr + 1, kids, zero, currHigh);
            kids[i] -= cookies[curr];
            zero += (kids[i] == 0) ? 1 : 0;
        }
    }
};
