class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        List<Map<Integer, Integer>> diffs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diffs.add(new HashMap<>());
            for (int j = i + 1; j < n; j++) {
                if (diffs.get(i).containsKey(nums[i] - nums[j])) continue;
                diffs.get(i).put(nums[i] - nums[j], j);
            }
        }
        int high = 0;
        for (int i = 0; i < n; i++) {
            if (i + high >= n) break;
            for (Map.Entry<Integer, Integer> pair : diffs.get(i).entrySet()) {
                high = Math.max(high, dfs(nums, diffs, pair.getValue(), pair.getKey(), 2));
            }
        }
        return high;
    }
    public int dfs(int[] nums, List<Map<Integer, Integer>> diffs, int i, int d, int count) {
        if (i == nums.length) return count;
        if (!diffs.get(i).containsKey(d)) return count;
        return dfs(nums, diffs, diffs.get(i).get(d), d, count + 1);
    }
}
