class Solution {
public:
    int findValueOfPartition(vector<int>& nums) {
        sort(begin(nums), end(nums));
        int low = 1000000007, n = nums.size();
        for (int i = 1; i < n; i++) {
            low = min(low, nums[i] - nums[i - 1]);
        }
        return low;
    }
};
