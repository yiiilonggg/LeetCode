class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        seen = dict(nums1)
        for x, y in nums2:
            seen[x] = seen[x] + y if x in seen else y
        return sorted(seen.items(), key = itemgetter(0))