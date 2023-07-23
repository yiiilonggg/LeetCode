class Solution {
public:
    long long maxArrayValue(vector<int>& nums) {
        int n = nums.size();
        long long high = 0, curr = 0;
        for (int i = n - 1; i >= 0; i--) {
            curr += nums[i];
            if (i == 0 || nums[i] < nums[i - 1]) {
                high = max(curr, high);
                if (i > 0 && curr < nums[i - 1]) curr = 0;
            }
        }
        return high;
    }
};
