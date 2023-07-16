class Solution {
public:
    int maximumBeauty(vector<int>& nums, int k) {
        sort(begin(nums), end(nums));
        int left = 0, right = 0, n = nums.size(), high = 0;
        while (right < n) {
            while (left < right && nums[right] - nums[left] > 2 * k) left++;
            while (right < n && nums[right] - nums[left] <= 2 * k) right++;
            high = max(high, right - left);
        }
        return high;
    }
};
