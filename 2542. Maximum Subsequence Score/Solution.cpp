class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        int n = nums1.size();
        long long total = 0, res = 0;
        vector<pair<int, int>> combined;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < n; i++) {
            pair<int, int> p(nums1[i], nums2[i]);
            combined.push_back(p);
        }
        auto cmp = [](auto& a, auto& b) -> bool { return (a.second == b.second) ? b.first < a.first : b.second < a.second; };
        sort(begin(combined), end(combined), cmp);
        for (auto& c : combined) {
            pq.push(c.first);
            total += c.first;
            if (pq.size() == k + 1) {
                total -= pq.top();
                pq.pop();
            }
            if (pq.size() == k) {
                res = max(res, total * c.second);
            }
        }
        return res;
    }
};
