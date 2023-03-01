# solution TLEs but it is a quicksort algorithm that runs in O(nlogn) and O(1) extra space
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quicksort(nums, 0, len(nums) - 1)
        return nums
    def quicksort(self, nums, left, right):
        if left >= right: return
        pivotIdx = self.partition(nums, left, right)
        self.quicksort(nums, left, pivotIdx - 1)
        self.quicksort(nums, pivotIdx + 1, right)
    def partition(self, nums, left, right):
        self.swap(nums, left, (right - left) // 2)
        pivot, m = nums[left], left
        for k in range(left + 1, right + 1):
            if nums[k] < pivot:
                m += 1
                self.swap(nums, k, m)
        self.swap(nums, left, m)
        return m
    def swap(self, nums, f, to):
        nums[f], nums[to] = nums[to], nums[f]