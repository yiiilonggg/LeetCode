class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int curr = nums[i];
            while (curr > 0) {
                res.add(curr % 10);
                curr /= 10;
            }
        }
        int[] r = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) r[res.size() - i - 1] = res.get(i);
        return r;
    }
}