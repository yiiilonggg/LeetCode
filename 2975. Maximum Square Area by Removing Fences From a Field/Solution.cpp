class Solution {
public:
    int maximizeSquareArea(int m, int n, vector<int>& hFences, vector<int>& vFences) {
        if (m == n) return 1ll * (m - 1) * (m - 1) % 1000000007;
        int high = -1, h = hFences.size(), v = vFences.size();
        unordered_set<int> hs;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < i; j++) {
                hs.insert(abs(hFences[i] - hFences[j]));
            }
            hs.insert(hFences[i] - 1);
            hs.insert(m - hFences[i]);
        }
        hs.insert(m - 1);
        if (hs.find(n - 1) != hs.end()) high = max(high, n - 1);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < i; j++) {
                if (hs.find(abs(vFences[i] - vFences[j])) != hs.end()) high = max(high, abs(vFences[i] - vFences[j]));
            }
            if (hs.find(vFences[i] - 1) != hs.end()) high = max(high, vFences[i] - 1);
            if (hs.find(n - vFences[i]) != hs.end()) high = max(high, n - vFences[i]);
        }
        return (high == -1) ? -1 : 1ll * high * high % 1000000007;
    }
};
