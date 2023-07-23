class Solution {
public:
    long long maxScore(vector<int>& nums, int x) {
        int n = nums.size();
        long long odd = -1000001, even = -1000001, curr = 0;
        if (nums[0] % 2 == 0) {
            even = nums[0];
        } else {
            odd = nums[0];
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                curr = max(even + nums[i], odd + nums[i] - x);
                even = max(even, curr);
            } else {
                curr = max(odd + nums[i], even + nums[i] - x);
                odd = max(odd, curr);
            }
        }
        return max(even, odd);
    }
};
