class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int firstPointer = 0, secondPointer = 0;
        while (firstPointer < n && secondPointer < m) {
            if (nums1[firstPointer] == nums2[secondPointer]) return nums1[firstPointer];
            if (nums1[firstPointer] < nums2[secondPointer]) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }
        return -1;
    }
}