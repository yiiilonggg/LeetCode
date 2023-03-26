class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> res = new ArrayList<>();
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] += 1L * prefix[i - 1] + nums[i];
        for (int q : queries) {
            int idx = Arrays.binarySearch(nums, q);
            if (idx >= 0) {
                long low = (idx == 0) ? 0 : 1L * q * idx - prefix[idx - 1];
                long high = (idx == n - 1) ? 0 : (prefix[n - 1] - prefix[idx]) - 1L * q * (n - idx - 1);
                res.add(high + low);
            } else {
                idx = -(idx + 1);
                if (idx == 0) {
                    res.add(prefix[n - 1] - 1L * q * n);
                } else if (idx == n) {
                    res.add(1L * q * n - prefix[n - 1]);
                } else {
                    long low = 1L * q * idx - prefix[idx - 1];
                    long high = (prefix[n - 1] - prefix[idx - 1]) - 1L * q * (n - idx);
                    res.add(high + low);
                }
            }
        }
        return res;
    }
}