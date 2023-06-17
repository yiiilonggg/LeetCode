class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int n = nums.size(), left = 0, right = 0;
        vector<string> res;
        while (left < n && right < n) {
            if (right + 1 < n && nums[right] + 1 == nums[right + 1]) {
                right++;
            } else {
                string str = "";
                if (right == left) {
                    str += to_string(nums[left]);
                } else {
                    str += to_string(nums[left]) + "->" + to_string(nums[right]);
                }
                res.push_back(str);
                left = right + 1;
                right++;
            }
        }
        return res;
    }
};
