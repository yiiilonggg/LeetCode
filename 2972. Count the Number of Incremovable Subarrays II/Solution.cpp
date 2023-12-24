class Solution {
public:
    long long incremovableSubarrayCount(vector<int>& nums) {
        int y = nums.size() - 1, n = nums.size();
        while (y > 0 && nums[y - 1] < nums[y]) y--;
        if (y == 0) return n * (n + 1) / 2;
        long long r = n - y + 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) break;
            while (y < nums.size() && nums[i] >= nums[y]) y++;
            r += n - y + 1;
        }
        return r;
    }
};
