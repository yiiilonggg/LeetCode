class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quicksort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivotIdx = partition(nums, left, right);
        quicksort(nums, left, pivotIdx - 1);
        quicksort(nums, pivotIdx + 1, right);
    }
    public int partition(int[] nums, int left, int right) {
        swap(nums, left, left + (right - left) / 2);
        int pivot = nums[left], m = left;
        for (int k = left + 1; k <= right; k++) {
            if (nums[k] < pivot) {
                m++;
                swap(nums, k, m);
            }
        }
        swap (nums, left, m);
        return m;
    }
    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}