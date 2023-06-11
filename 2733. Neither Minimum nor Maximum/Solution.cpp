class Solution {
public:
    int findNonMinOrMax(vector<int>& nums) {
        if (nums.size() <= 2) return -1;
        int high = *max_element(begin(nums), end(nums)), low = *min_element(begin(nums), end(nums));
        for (int n : nums) {
            if (high > n && low < n) return n;
        }
        return -1;
    }
};
