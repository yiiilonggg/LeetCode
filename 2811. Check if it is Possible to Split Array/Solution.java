class Solution {
    Map<Integer, Set<Integer>> memo = new HashMap<>();
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size(), s = 0;
        if (n <= 2) return true;
        for (int i : nums) s += i;
        return r(nums, 0, n - 1, s, m);
    }

    public boolean r(List<Integer> nums, int left, int right, int s, int m) {
        if (left >= right) return true;
        if (s < m) return false;
        if (memo.containsKey(left) && memo.get(left).contains(right)) return false;
        if (r(nums, left + 1, right, s - nums.get(left), m) || r(nums, left, right - 1, s - nums.get(right), m)) return true;
        if (!memo.containsKey(left)) memo.put(left, new HashSet<>());
        memo.get(left).add(right);
        return false;
    }
}
