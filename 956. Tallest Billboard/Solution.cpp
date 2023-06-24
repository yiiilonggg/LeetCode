class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        int n = rods.size(), res = 0;
        unordered_map<int, int> first = split(rods, 0, n / 2), second = split(rods, n / 2, n);
        for (const auto& [k, v] : first) {
            if (second.find(-k) != second.end()) {
                res = max(res, v + second[-k]);
            }
        }
        return res;
    }

    unordered_map<int, int> split(vector<int>& rods, int start, int end) {
        auto hash = [](const pair<int, int>& p){ return p.first * 31 + p.second; };
        unordered_set<pair<int, int>, decltype(hash)> states(0, hash);
        states.insert(pair(0, 0));
        for (int i = start; i < end; i++) {
            unordered_set<pair<int, int>, decltype(hash)> curr(0, hash);
            for (const auto& p : states) {
                curr.insert(pair(p.first + rods[i], p.second));
                curr.insert(pair(p.first, p.second + rods[i]));
            }
            for (const auto& p : curr) states.insert(p);
        }
        unordered_map<int, int> dp;
        for (const auto& p : states) {
            if (dp.find(p.first - p.second) == dp.end()) {
                dp[p.first - p.second] = p.first;
            } else {
                dp[p.first - p.second] = max(dp[p.first - p.second], p.first);
            }
        }
        return dp;
    }
};
