class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int l = queries.length, a = 0;
        int[] cols = new int[n], res = new int[l];
        for (int i = 0; i < l; i++) {
            int j = queries[i][0], c = queries[i][1];
            if (c != cols[j]) {
                if (j > 0 && cols[j - 1] != 0 && cols[j - 1] == cols[j] && cols[j - 1] != c) a--;
                if (j < n - 1 && cols[j + 1] != 0 && cols[j + 1] == cols[j] && cols[j + 1] != c) a--;
                cols[j] = c;
                if (j > 0 && cols[j - 1] == c) a++;
                if (j < n - 1 && cols[j + 1] == c) a++;
            }
            res[i] = a;
        }
        return res;
    }
}