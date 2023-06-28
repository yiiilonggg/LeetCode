class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size(), m = nums2.size();
        auto cmp = [](const auto& a, const auto& b) { return a[0] > b[0]; };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        unordered_map<int, unordered_set<int>> seen;
        vector<vector<int>> res;
        pq.push(vector<int> { nums1[0] + nums2[0], 0, 0 });
        unordered_set<int> s;
        seen[0] = s;
        seen[0].insert(0);
        while (!pq.empty() && k > 0) {
            vector<int> curr = pq.top();
            pq.pop();
            res.push_back(vector<int> { nums1[curr[1]], nums2[curr[2]] });
            k--;
            if (curr[1] < n - 1 && (seen.find(curr[1] + 1) == seen.end() || seen[curr[1] + 1].find(curr[2]) == seen[curr[1] + 1].end())) {
                pq.push(vector<int> { nums1[curr[1] + 1] + nums2[curr[2]], curr[1] + 1, curr[2]});
                if (seen.find(curr[1] + 1) == seen.end()) {
                    unordered_set<int> s;
                    seen[curr[1] + 1] = s;
                }
                seen[curr[1] + 1].insert(curr[2]);
            }
            if (curr[2] < m - 1 && (seen.find(curr[1]) == seen.end() || seen[curr[1]].find(curr[2] + 1) == seen[curr[1]].end())) {
                pq.push(vector<int> { nums1[curr[1]] + nums2[curr[2] + 1], curr[1], curr[2] + 1});
                if (seen.find(curr[1]) == seen.end()) {
                    unordered_set<int> s;
                    seen[curr[1]] = s;
                }
                seen[curr[1]].insert(curr[2] + 1);
            }
        }
        return res;
    }
};
