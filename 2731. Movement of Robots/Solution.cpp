class Solution {
public:
    int sumDistance(vector<int>& nums, string s, int d) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            nums[i] = (s[i] == 'R') ? nums[i] + d : nums[i] - d;
        }
        sort(begin(nums), end(nums));
        long long MOD = 1000000007, prev = nums[0], prefix = 0, res = 0;
        for (int i = 1; i < n; i++) {
            res = (res + prefix + i * abs(nums[i] - prev)) % MOD;
            prefix = (prefix + i * abs(nums[i] - prev)) % MOD;
            prev = nums[i];
        }
        return res;
    }
};
