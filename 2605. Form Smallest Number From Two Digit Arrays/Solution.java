class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> seen = new HashSet<>();
        int first = 10, second = 10, n = nums1.length, m = nums2.length;
        for (int i = 0; i < n; i++) {
            seen.add(nums1[i]);
            first = Math.min(first, nums1[i]);
        }
        for (int i = 0; i < m; i++) {
            if (seen.contains(nums2[i])) return nums2[i];
            second = Math.min(second, nums2[i]);
        }
        return (first < second) ? first * 10 + second : second * 10 + first;
    }
}