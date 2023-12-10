class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        long long res = 0;
        int l = nums.size(), high = 0, qptr = -1;
        for (int n : nums) high = max(high, n);
        vector<int> idx;
        for (int i = 0; i < l; i++) {
            if (nums[i] == high) {
                idx.push_back(i);
                if (idx.size() >= k) qptr++;
            }
            if (idx.size() >= k) {
                int last = idx[qptr] + 1;
                res += last * 1l;
            }
        }
        return res;
    }
};
