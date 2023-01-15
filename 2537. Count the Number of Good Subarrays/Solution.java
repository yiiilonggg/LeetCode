class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0, pairs = 0;
        int n = nums.length;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int left = 0, right = 0; left < n; left++) {
            while (right < n && pairs < k) {
                pairs += counter.getOrDefault(nums[right], 0);
                counter.put(nums[right], counter.getOrDefault(nums[right], 0) + 1);
                right++;
            }
            if (pairs >= k) {
                res += n - right + 1;
            }
            pairs -= counter.get(nums[left]) - 1;
            counter.put(nums[left], counter.get(nums[left]) - 1);
        }
        return res;
    }
}