class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        int n = nums.size();
        vector<unordered_map<int, int>> diffs;
        for (int i = 0; i < n; i++) {
            unordered_map<int, int> diff;
            for (int j = i + 1; j < n; j++) {
                if (diff.find(nums[i] - nums[j]) != diff.end()) continue;
                diff[nums[i] - nums[j]] = j;
            }
            diffs.push_back(diff);
        }
        int high = 0;
        for (int i = 0; i < n; i++) {
            if (i + high >= n) break;
            for (const auto& [k, v] : diffs[i]) {
                high = max(high, dfs(nums, diffs, v, k, 2));
            }
        }
        return high;
    }

    int dfs(vector<int>& nums, vector<unordered_map<int, int>>& diffs, int i, int d, int count) {
        if (i == nums.size()) return count;
        if (diffs[i].find(d) == diffs[i].end()) return count;
        return dfs(nums, diffs, diffs[i][d], d, count + 1);
    }
};
