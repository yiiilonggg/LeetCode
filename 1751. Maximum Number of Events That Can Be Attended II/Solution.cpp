class Solution {
public:
    unordered_map<int, unordered_map<int, int>> memo;
    int maxValue(vector<vector<int>>& events, int k) {
        sort(begin(events), end(events), [](const auto& a, const auto& b) {
            return (a[0] == b[0]) ? a[1] < b[1] : a[0] < b[0];
        });
        for (int i = 0; i < events.size(); i++) {
            unordered_map<int, int> m;
            memo[i] = m;
        }
        return r(events, 0, 0, k);
    }
    int r(vector<vector<int>>& events, int curr, int tot, int k) {
        if (k == 0 || curr == events.size()) return tot;
        if (memo[curr].find(k) != memo[curr].end()) return tot + memo[curr][k];
        int a = r(events, curr + 1, tot, k);
        int left = curr, right = events.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= events[curr][1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int b = r(events, left, tot + events[curr][2], k - 1);
        memo[curr][k] = max(a, b) - tot;
        return max(a, b);
    }
};
