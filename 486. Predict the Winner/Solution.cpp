class Solution {
public:
    vector<vector<vector<int>>> memo;
    int unvisited;
    bool PredictTheWinner(vector<int>& nums) {
        unvisited = 20 * 10000000;
        int l = nums.size();
        memo.assign(2, vector<vector<int>>(l, vector<int>(l, unvisited)));
        return r(nums, 0, l - 1, 0, 0) >= 0;
    }
    int r(vector<int>& nums, int left, int right, int curr, int turn) {
        if (left > right) return curr;
        if (left == right) return curr + nums[left];
        if (memo[turn][left][right] != unvisited) return curr + memo[turn][left][right];
        if (turn == 0) {
            int chooseLeft = r(nums, left + 1, right, curr + nums[left], 1);
            int chooseRight = r(nums, left, right - 1, curr + nums[right], 1);
            memo[turn][left][right] = max(chooseLeft, chooseRight) - curr;
            return max(chooseLeft, chooseRight);
        } else {
            int chooseLeft = r(nums, left + 1, right, curr - nums[left], 0);
            int chooseRight = r(nums, left, right - 1, curr - nums[right], 0);
            memo[turn][left][right] = min(chooseLeft, chooseRight) - curr;
            return min(chooseLeft, chooseRight);
        }
    }
};
