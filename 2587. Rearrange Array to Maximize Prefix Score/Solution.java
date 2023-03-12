class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count;
        long prefix = 1L * nums[n - 1];
        if (prefix <= 0) return 0;
        for (count = 1; count < n && prefix > 0; count++) prefix += nums[n - 1 - count];
        return (prefix > 0) ? n : count - 1;
    }
}