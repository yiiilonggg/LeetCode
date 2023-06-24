class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] s = new int[n][2];
        for (int i = 0; i < n; i++) {
            s[i][0] = nums[i];
            s[i][1] = cost[i];
        }
        Arrays.sort(s, (a, b) -> a[0] - b[0]);
        long[] front = new long[n], back = new long[n];
        long frontm = s[0][1], backm = s[n - 1][1];
        for (int i = 1; i < n; i++) {
            front[i] = 1L * (s[i][0] - s[i - 1][0]) * frontm + front[i - 1];
            back[n - i - 1] = 1L * (s[n - i][0] - s[n - i - 1][0]) * backm + back[n - i];
            frontm += s[i][1];
            backm += s[n - i - 1][1];
        }
        long low = front[0] + back[0];
        for (int i = 1; i < n; i++) {
            low = Math.min(low, front[i] + back[i]);
        }
        return low;
    }
}
