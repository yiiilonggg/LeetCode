class Solution {
public:
    int alternatingSubarray(vector<int>& nums) {
        int n = nums.size(), high = 0, left = 0, right = 1;
        while (right < n) {
            while (right < n && nums[right] != nums[right - 1] + 1) right++;
            if (right == n) break;
            left = right - 1;
            int x = nums[left], y = nums[right];
            bool alt = false;
            while (right < n) {
                if ((alt && nums[right] != x) || (!alt && nums[right] != y)) break;
                right++;
                alt = !alt;
            }
            high = max(high, right - left);
        }
        return (high > 0) ? high : -1;
    }
};
