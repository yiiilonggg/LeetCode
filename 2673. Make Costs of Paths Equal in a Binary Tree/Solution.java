class Solution {
    int res;
    public int minIncrements(int n, int[] cost) {
        res = 0;
        dfs(1, cost);
        return res;
    }
    public int dfs(int curr, int[] cost) {
        if (curr * 2 > cost.length) return 0;
        int left = cost[curr * 2 - 1] + dfs(curr * 2, cost), right = cost[curr * 2] + dfs(curr * 2 + 1, cost);
        res += Math.abs(left - right);
        return Math.max(left, right);
    }
}