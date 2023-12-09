class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        map<int, int> m;
        int left = 0, res = 0, l = nums.size();
        for (int right = 0; right < l; right++) {
            if (m.find(nums[right]) == m.end()) m[nums[right]] = 0;
            m[nums[right]]++;
            while (m[nums[right]] > k) {
                m[nums[left]]--;
                left++;
            }
            res = max(res, right - left + 1);
        }
        return res;
    }
};
