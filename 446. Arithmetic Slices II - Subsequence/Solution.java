class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, res = 0;
        Map<Integer, Integer>[] diff = new Map[n];
        for (int i = 0; i < n; i++) {
            diff[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long holder = (long) nums[i] - (long) nums[j];
                if (holder > Integer.MAX_VALUE || holder < Integer.MIN_VALUE) continue;
                int currDiff = (int) holder;
                res += diff[j].getOrDefault(currDiff, 0);
                diff[i].put(currDiff, diff[i].getOrDefault(currDiff, 0) + diff[j].getOrDefault(currDiff, 0) + 1);
            }
        }
        return res;
    }
}
