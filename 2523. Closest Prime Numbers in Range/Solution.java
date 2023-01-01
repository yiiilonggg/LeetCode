class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] sieve = new boolean[right + 1];
        int resFirst = -1, resSecond = -1, prev = -1, diff = 1000000;
        for (int i = 2; i < right + 1; i++) {
            if (sieve[i]) continue;
            for (int j = i + i; j < right + 1; j += i) sieve[j] = true;
            if (i >= left) {
                if (prev != -1 && i - prev < diff) {
                    resFirst = prev;
                    resSecond = i;
                    diff = i - prev;
                }
                prev = i;
            }
        }
        return new int[] { resFirst, resSecond };
    }
}
