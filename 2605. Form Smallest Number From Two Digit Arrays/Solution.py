class Solution:
    def minNumber(self, nums1: List[int], nums2: List[int]) -> int:
        c, first, second = sorted(set(nums1).intersection(nums2)), min(nums1), min(nums2)
        return c[0] if c else first * 10 + second if first < second else second * 10 + first