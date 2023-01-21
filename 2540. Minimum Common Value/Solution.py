class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        firstPointer, secondPointer = 0, 0
        while firstPointer < n and secondPointer < m:
            if nums1[firstPointer] == nums2[secondPointer]: return nums1[firstPointer]
            if nums1[firstPointer] < nums2[secondPointer]:
                firstPointer += 1
            else:
                secondPointer += 1
        return -1