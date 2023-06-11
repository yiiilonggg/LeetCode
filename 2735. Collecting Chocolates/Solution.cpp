class Solution {
public:
    long long minCost(vector<int>& nums, int x) {
        int n = nums.size();
        vector<long long> res;
        for (int i = 0; i < n; i++) res.push_back(1LL * x * i);
        for (int i = 0; i < n; i++) {
            long long curr = 1LL * nums[i];
            for (int j = 0; j < n; j++) {
                curr = min(curr, 1LL * nums[(i - j + n) % n]);
                res[j] += curr;
            }
        }
        long long r = res[0];
        for (long long l : res) r = min(r, l);
        return r;
    }
};
