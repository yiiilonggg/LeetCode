class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        n = nums.length;
        Arrays.sort(nums);
        findSum(nums, (long) target, 0, 4, new ArrayList<>());
        return res;
    }
    public void findSum(int[] nums, long target, int curr, int N, List<Integer> currList) {
        if (target < (long) nums[curr] * N || target > (long) nums[n - 1] * N) return;
        if (N == 2) {
            int left = curr, right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    currList.add(nums[left]);
                    currList.add(nums[right]);
                    res.add(new ArrayList<>(currList));
                    currList.remove(3);
                    currList.remove(2);
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) left++;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = curr; i < n - N + 1; i++) {
                if (i > curr && nums[i] == nums[i - 1]) continue;
                currList.add(nums[i]);
                findSum(nums, target - nums[i], i + 1, N - 1, currList);
                currList.remove(4 - N);
            }
        }
    }
}