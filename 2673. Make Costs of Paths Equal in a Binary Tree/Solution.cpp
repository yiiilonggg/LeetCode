class Solution {
public:
    int res = 0;
    int minIncrements(int n, vector<int>& cost) {
        dfs(1, cost);
        return res;
    }

    int dfs(int curr, vector<int>& cost) {
        if (curr * 2 > cost.size()) return 0;
        int left = cost[curr * 2 - 1] + dfs(curr * 2, cost), right = cost[curr * 2] + dfs(curr * 2 + 1, cost);
        res += abs(left - right);
        return max(left, right);
    }
};