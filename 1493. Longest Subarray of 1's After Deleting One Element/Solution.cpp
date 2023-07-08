class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int n = nums.size(), high = 0, zero = 0, left = 0;
        for (int right = 0; right < n; right++) {
            zero += (nums[right] == 0) ? 1 : 0;
            while (zero > 1) {
                zero -= (nums[left] == 0) ? 1 : 0;
                left++;
            }
            high = max(high, right - left);
        }
        return high;
    }
};
