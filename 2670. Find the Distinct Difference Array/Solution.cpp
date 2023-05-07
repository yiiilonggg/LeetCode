class Solution {
public:
    vector<int> distinctDifferenceArray(vector<int>& nums) {
        int n = nums.size(), p = 0, s = 0;
        vector<int> prefix(51, 0), suffix(51, 0), res(n, 0);
        for (int i = 0; i < n; i++) {
            suffix[nums[i]]++;
            if (suffix[nums[i]] == 1) s++;
        }
        for (int i = 0; i < n; i++) {
            suffix[nums[i]]--;
            prefix[nums[i]]++;
            if (suffix[nums[i]] == 0) s--;
            if (prefix[nums[i]] == 1) p++;
            res[i] = p - s;
        }
        return res;
    }
};