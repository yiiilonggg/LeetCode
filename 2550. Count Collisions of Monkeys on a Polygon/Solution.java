class Solution {
    public int monkeyMove(int n) {
        int high = Integer.highestOneBit(n);
        long MOD = 1000000007, e = 2;
        for (high >>= 1; high > 0; high >>= 1) {
            e = (e * e) % MOD;
            if ((high & n) != 0) e = (e * 2);
        }
        return (int) (((e + MOD) - 2) % MOD);
    }
}