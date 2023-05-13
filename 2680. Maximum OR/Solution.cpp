class Solution {
public:
    long long maximumOr(vector<int>& nums, int k) {
        if (nums.size() == 1) return 1ll * nums[0] << k;
        int high = 0;
        long long res = 0;
        vector<int> bits(32, 0);
        vector<int> p;
        for (int n : nums) {
            int i;
            for (i = 0; (1ll << i) <= n; i++) {
                if (((1ll << i) & n) > 0) bits[i]++;
            }
            if (i > high) {
                high = i;
                p.clear();
                p.push_back(n);
            } else if (i == high) {
                p.push_back(n);
            }
        }
        for (int q : p) {
            long long r = 1ll * q << k;
            for (int i = 0; i < 32; i++) {
                if (bits[i] == 0 || ((1ll << i) & r) > 0) continue;
                if (((1ll << i) & q) > 0 && bits[i] == 1) continue;
                r |= (1ll << i);
            }
            res = max(res, r);
        }
        return res;
    }
};