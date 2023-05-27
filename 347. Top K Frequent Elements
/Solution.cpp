class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int n = nums.size(), pointer = 0;
        unordered_map<int, int> seen;
        vector<vector<int>> buckets;
        vector<int> res;
        for (int i = 0; i < n + 1; i++) {
            vector<int> bucket;
            buckets.push_back(bucket);
        }
        for (auto& num : nums) {
            if (seen.find(num) == seen.end()) seen[num] = 0;
            seen[num]++;
        }
        for (auto& [key, val] : seen) buckets[val].push_back(key);
        for (int i = n; i >= 0 && k > 0; i--) {
            if (buckets[i].empty()) continue;
            for (int b : buckets[i]) res.push_back(b);
            k -= buckets[i].size();
        }
        return res;
    }
};
