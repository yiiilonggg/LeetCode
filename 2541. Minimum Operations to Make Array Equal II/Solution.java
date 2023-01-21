class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long inc = 0, dec = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) continue;
            if (k == 0) return -1;
            if (Math.abs(nums1[i] - nums2[i]) % k != 0) return -1;
            if (nums1[i] > nums2[i]) {
                dec += (nums1[i] - nums2[i]) / k;
            } else {
                inc += (nums2[i] - nums1[i]) / k;
            }
        }
        if (inc != dec) return -1;
        return inc;
    }
}