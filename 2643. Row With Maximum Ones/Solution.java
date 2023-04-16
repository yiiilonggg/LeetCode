class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int[] res = { 0, 0 };
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j : mat[i]) curr += j;
            if (curr > res[1]) {
                res[0] = i;
                res[1] = curr;
            }
        }
        return res;
    }
}