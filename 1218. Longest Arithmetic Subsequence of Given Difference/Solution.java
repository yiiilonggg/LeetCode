class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int high = 0;
        for (int a : arr) {
            dp.put(a, dp.getOrDefault(a - difference, 0) + 1);
        }
        for (int h : dp.values()) {
            high = Math.max(high, h);
        }
        return high;
    }
}
