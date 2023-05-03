class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> a(begin(nums1), end(nums1)), b(begin(nums2), end(nums2)), c, d;
        for (auto& n : nums1) if (b.find(n) == b.end()) c.insert(n);
        for (auto& n : nums2) if (a.find(n) == b.end()) d.insert(n);
        vector<vector<int>> res;
        vector<int> e(begin(c), end(c)), f(begin(d), end(d));
        res.push_back(e);
        res.push_back(f);
        return res;
    }
};