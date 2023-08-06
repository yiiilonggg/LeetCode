class Solution {
public:
    unordered_map<int, unordered_set<int>> memo;
    bool canSplitArray(vector<int>& nums, int m) {
        int n = nums.size(), s = accumulate(begin(nums), end(nums), 0);
        if (n <= 2) return true;
        return r(nums, 0, n - 1, s, m);
    }
    bool r(vector<int>& nums, int left, int right, int s, int m) {
        if (left >= right) return true;
        if (s < m) return false;
        if (memo.find(left) != memo.end() && memo[left].find(right) != memo[left].end()) return false;
        if (r(nums, left + 1, right, s - nums[left], m) || r(nums, left, right - 1, s - nums[right], m)) return true;
        if (memo.find(left) == memo.end()) {
            unordered_set<int> c;
            memo[left] = c;
        }
        memo[left].insert(right);
        return false;
    }
};
