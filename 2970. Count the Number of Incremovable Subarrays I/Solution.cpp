class Solution {
public:
    int incremovableSubarrayCount(vector<int>& nums) {
        int n = nums.size(), t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(nums, i, j)) t++;
            }
        }
        return t;
    }
    bool check(vector<int>& nums, int l, int r) {
        int n = nums.size(), prev = 0;
        for (int i = 0; i < n; i++) {
            if (i >= l && i <= r) continue;
            if (nums[i] <= prev) return false;
            prev = nums[i];
        }
        return true;
    }
};
