class Solution {
public:
    bool isGood(vector<int>& nums) {
        int l = nums.size(), high = *max_element(begin(nums), end(nums));
        if (l != high + 1) return false;
        vector<int> counter(high + 1, 0);
        for (int n : nums) counter[n]++;
        for (int i = 1; i < high; i++) {
            if (counter[i] != 1) return false;
        }
        return counter[high] == 2;
    }
};
