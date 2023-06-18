class Solution {
public:
    long long MOD = 1000000007;
    vector<vector<long long>> pascals;
    int numOfWays(vector<int>& nums) {
        int n = nums.size();
        for (int i = 0; i < n + 1; i++) {
            vector<long long> layer(i + 1, 1);
            pascals.push_back(layer);
            for (int j = 1; j < i; j++) {
                pascals[i][j] = (pascals[i - 1][j - 1] + pascals[i - 1][j]) % MOD;
            }
        }
        return (int) ((dfs(nums) - 1) % MOD);
    }

    long long dfs(vector<int> nums) {
        if (nums.size() < 3) return 1;
        vector<int> left, right;
        int l = nums.size();
        for (int i = 1; i < l; i++) {
            if (nums[i] < nums[0]) {
                left.push_back(nums[i]);
            } else {
                right.push_back(nums[i]);
            }
        }
        long long countLeft = dfs(left) % MOD;
        long long countRight = dfs(right) % MOD;
        return (((countLeft * countRight) % MOD) * pascals[l - 1][left.size()]) % MOD;
    }
};
