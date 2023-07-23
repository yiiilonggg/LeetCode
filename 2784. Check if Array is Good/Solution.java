class Solution {
    public boolean isGood(int[] nums) {
        int l = nums.length, high = 0;
        for (int n : nums) high = Math.max(high, n);
        if (l != high + 1) return false;
        int[] counter = new int[high + 1];
        for (int n : nums) counter[n]++;
        for (int i = 1; i < high; i++) {
            if (counter[i] != 1) return false;
        }
        return counter[high] == 2;
    }
}
