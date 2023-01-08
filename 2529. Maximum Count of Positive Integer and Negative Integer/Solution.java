class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int n : nums) {
            if (n < 0) neg++;
            if (n > 0) pos++;
        }
        return Math.max(pos, neg);
    }
}