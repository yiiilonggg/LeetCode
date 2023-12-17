class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> r;
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i + 1] > k || nums[i + 2] - nums[i] > k) return {};
            r.push_back({nums[i], nums[i + 1], nums[i + 2]});
        }
        return r;
    }
};
