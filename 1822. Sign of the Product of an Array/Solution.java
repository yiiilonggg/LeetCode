class Solution {
    public int arraySign(int[] nums) {
        boolean neg = false;
        for (int n : nums) {
            if (n == 0) return 0;
            if (n < 0) neg = !neg;
        }
        return (neg) ? -1 : 1;
    }
}