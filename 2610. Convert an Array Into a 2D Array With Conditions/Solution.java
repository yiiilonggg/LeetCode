class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length, high = 0;
        int[] counter = new int[n + 1];
        List<List<Integer>> res = new ArrayList<>();
        for (int i : nums) {
            counter[i]++;
            high = Math.max(high, counter[i]);
        }
        for (int i = 0; i < high; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (counter[j] > 0) curr.add(j);
                counter[j]--;
            }
            res.add(curr);
        }
        return res;
    }
}