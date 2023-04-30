class Solution {
public:
    int maximizeSum(vector<int>& nums, int k) {
        int high = *max_element(nums.begin(), nums.end());
        return high * k + k * (k - 1) / 2;
    }
};