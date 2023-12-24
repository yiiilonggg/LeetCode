class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        long long t = 0;
        for (auto n : nums) t += n * 1ll;
        int i = nums.size() - 1;
        while (i > 1 && nums[i] >= t - nums[i]) {
            t -= nums[i];
            i--;
        }
        return (i == 1) ? -1 : t;
    }
};
