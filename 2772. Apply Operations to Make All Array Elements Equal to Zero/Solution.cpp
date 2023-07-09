class Solution {
public:
    bool checkArray(vector<int>& nums, int k) {
        int n = nums.size(), m = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] - m < 0) return false;
            nums[i] -= m;
            m += nums[i];
            if (i >= k - 1) m -= nums[i - k + 1];
        }
        return m == 0;
    }
};
