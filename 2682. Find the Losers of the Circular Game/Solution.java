class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] b = new boolean[n];
        int i = 1, j = 0, c = 0, a = 0;
        while (true) {
            if (b[c]) break;
            b[c] = true;
            c = (c + i * k) % (n);
            i++;
        }
        for (int d = 0; d < n; d++) {
            if (!b[d]) a++;
        }
        int[] res = new int[a];
        for (int d = 0; d < n; d++) {
            if (!b[d]) {
                res[j] = d + 1;
                j++;
            }
        }
        return res;
    }
}