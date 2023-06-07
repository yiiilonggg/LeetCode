class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0) {
            int j = a & 1, k = b & 1, l = c & 1;
            if (l == 0) {
                count += j + k;
            } else {
                if (j == 0 && k == 0) count++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}
