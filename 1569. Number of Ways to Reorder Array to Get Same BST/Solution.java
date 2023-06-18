class Solution {
    long MOD = 1000000007;
    List<long[]> pascals = new ArrayList<>();
    public int numOfWays(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n + 1; i++) {
            long[] layer = new long[i + 1];
            Arrays.fill(layer, 1);
            pascals.add(layer);
            for (int j = 1; j < i; j++) {
                pascals.get(i)[j] = (pascals.get(i - 1)[j - 1] + pascals.get(i - 1)[j]) % MOD;
            }
        }
        return (int) ((dfs(nums) - 1) % MOD);
    }

    public long dfs(int[] nums) {
        if (nums.length < 3) return 1;
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            if (nums[i] < nums[0]) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }
        int[] leftarr = left.stream().mapToInt(i -> i).toArray();
        int[] rightarr = right.stream().mapToInt(i -> i).toArray();
        long countLeft = dfs(leftarr) % MOD;
        long countRight = dfs(rightarr) % MOD;
        return (((countLeft * countRight) % MOD) * pascals.get(l - 1)[left.size()]) % MOD;  
    }
}
