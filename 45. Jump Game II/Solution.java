class Solution {
    public int jump(int[] nums) {
        int n = nums.length, curr = 0, high = 0, count = 0;
        if (n == 1) return 0;
        while (high < n - 1) {
            int nextHigh = high, nextCurr = curr;
            for (int i = curr; i <= high; i++) {
                if (i + nums[i] > nextHigh) {
                    nextHigh = i + nums[i];
                    nextCurr = i;
                }
            }
            curr = nextCurr;
            high = nextHigh;
            count++;
        }
        return count;
    }
}