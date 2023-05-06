class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        sort(begin(nums), end(nums));
        int res = 0, mod = 1000000007, left = 0, right = nums.size() - 1, p = 1;
        vector<int> power;
        for (int i = 0; i < nums.size(); i++) {
            power.push_back(p);
            p = (p << 1) % mod;
        }
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + power[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
};
