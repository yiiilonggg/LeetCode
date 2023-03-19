class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += backtrack(nums, k, i, new HashSet<>());
        }
        return res;
    }
    public int backtrack(int[] nums, int k, int i, Set<Integer> curr) {
        if (i == nums.length) return 0;
        int total = 1;
        curr.add(nums[i]);
        for (int j = i + 1; j < nums.length; j++) {
            if (curr.contains(nums[j] - k) || curr.contains(k + nums[j])) continue;
            total += backtrack(nums, k, j, curr);
        }
        curr.remove(nums[i]);
        return total;
    }
}