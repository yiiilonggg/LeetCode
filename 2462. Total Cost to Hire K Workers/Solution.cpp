class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        long long res = 0;
        int n = costs.size(), left = 0, right = costs.size() - 1;
        auto cmp = [](const auto& a, const auto& b) { return (a[0] == b[0]) ? a[1] > b[1] : a[0] > b[0]; };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        while (left < candidates) {
            pq.push(vector<int> { costs[left], -1 });
            left++;
        }
        while (right >= max(left, n - candidates)) {
            pq.push(vector<int> { costs[right], 1 });
            right--;
        }
        for (int i = 0; i < k && !pq.empty(); i++) {
            vector<int> curr = pq.top();
            pq.pop();
            res += 1LL * curr[0];
            if (left > right) continue;
            if (curr[1] == -1) {
                pq.push(vector<int> { costs[left], -1 });
                left++;
            } else {
                pq.push(vector<int> { costs[right], 1 });
                right--;
            }
        }
        return res;
        
    }
};
