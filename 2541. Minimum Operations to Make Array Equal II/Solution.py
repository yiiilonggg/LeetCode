class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int], k: int) -> int:
        n, inc, dec = len(nums1), 0, 0
        for i in range(n):
            if nums1[i] == nums2[i]: continue
            if k == 0: return -1
            if abs(nums1[i] - nums2[i]) % k != 0: return -1
            if nums1[i] > nums2[i]:
                inc += (nums1[i] - nums2[i]) // k
            else:
                dec += (nums2[i] - nums1[i]) // k
        if inc != dec: return -1
        return inc