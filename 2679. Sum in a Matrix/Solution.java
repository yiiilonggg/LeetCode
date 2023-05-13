class Solution {
    public int matrixSum(int[][] nums) {
        int r = nums.length, c = nums[0].length, res = 0;
        PriorityQueue<Integer>[] pqs = new PriorityQueue[r];
        for (int i = 0; i < r; i++) {
            pqs[i] = new PriorityQueue<>((a, b) -> b - a);
            for (int j = 0; j < c; j++) pqs[i].offer(nums[i][j]);
        }
        for (int i = 0; i < c; i++) {
            int high = 0;
            for (int j = 0; j < r; j++) high = Math.max(high, pqs[j].poll());
            res += high;
        }
        return res;
    }
}