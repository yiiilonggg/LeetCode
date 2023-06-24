class Solution {
public:
    long long minCost(vector<int>& nums, vector<int>& cost) {
        int n = nums.size();
        vector<pair<int, int>> s;
        for (int i = 0; i < n; i++) {
            s.push_back(pair(nums[i], cost[i]));
        }
        sort(begin(s), end(s), [](auto& a, auto& b) { return a.first < b.first; });
        vector<long long> front(n, 0), back(n, 0);
        long frontm = s[0].second, backm = s[n - 1].second;
        for (int i = 1; i < n; i++) {
            front[i] = (long long) (s[i].first - s[i - 1].first) * frontm + front[i - 1];
            back[n - i - 1] = (long long) (s[n - i].first - s[n - i - 1].first) * backm + back[n - i];
            frontm += s[i].second;
            backm += s[n - i - 1].second;
        }
        long long low = front[0] + back[0];
        for (int i = 1; i < n; i++) {
            low = min(low, front[i] + back[i]);
        }
        return low;
    }
};
