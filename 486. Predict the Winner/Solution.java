class Solution {
    int[][][] memo;
    int unvisited = 20 * 10000000;
    public boolean PredictTheWinner(int[] nums) {
        int l = nums.length;
        memo = new int[2][l][l];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < l; j++) Arrays.fill(memo[i][j], unvisited);
        }
        return r(nums, 0, nums.length - 1, 0, 0) >= 0;
    }
    public int r(int[] nums, int left, int right, int curr, int turn) {
        if (left > right) return curr;
        if (left == right) return curr + nums[left];
        if (memo[turn][left][right] != unvisited) return memo[turn][left][right] + curr;
        if (turn == 0) {
            int chooseLeft = r(nums, left + 1, right, curr + nums[left], 1);
            int chooseRight = r(nums, left, right - 1, curr + nums[right], 1);
            memo[turn][left][right] = Math.max(chooseLeft, chooseRight) - curr;
            return Math.max(chooseLeft, chooseRight);
        } else {
            int chooseLeft = r(nums, left + 1, right, curr - nums[left], 0);
            int chooseRight = r(nums, left, right - 1, curr - nums[right], 0);
            memo[turn][left][right] = Math.min(chooseLeft, chooseRight) - curr;
            return Math.min(chooseLeft, chooseRight);
        }
    }
}
