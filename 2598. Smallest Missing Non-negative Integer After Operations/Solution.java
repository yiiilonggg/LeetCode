class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] counter = new int[value];
        for (int n : nums) {
            if (n < 0) {
                if (n % value == 0) {
                    counter[-(n % value)]++;
                } else {
                    counter[value - (-n % value)]++;
                }
            } else {
                counter[n % value]++;
            }
        }
        int low = nums.length, pos = 0;
        for (int i = 0; i < value; i++) {
            if (counter[i] == 0) return i;
            if (counter[i] < low) {
                low = counter[i];
                pos = i;
            }
        }
        return value * low + pos;
    }
}