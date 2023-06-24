class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        int n = nums.size();
        long long curr = 0;
        vector<int> res(n, -1);
        for (int i = 0; i < min(n, 2 * k); i++) curr += nums[i];
        for (int i = k; i < n - k; i++) {
            curr += nums[i + k];
            res[i] = (int) (curr / (2 * k + 1));
            curr -= nums[i - k];
        }
        return res;
    }
};
