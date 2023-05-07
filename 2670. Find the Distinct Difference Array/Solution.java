class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length, p = 0, s = 0;
        int[] prefix = new int[51], suffix = new int[51], res = new int[n];
        for (int i : nums) {
            suffix[i]++;
            if (suffix[i] == 1) s++;
        }
        for (int i = 0; i < n; i++) {
            suffix[nums[i]]--;
            prefix[nums[i]]++;
            if (prefix[nums[i]] == 1) p++;
            if (suffix[nums[i]] == 0) s--;
            res[i] = p - s;
        }
        return res;
    }
}