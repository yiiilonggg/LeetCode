class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] separators = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            separators[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(separators);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += separators[n - i - 2] - separators[i];
        }
        return res;
    }
}