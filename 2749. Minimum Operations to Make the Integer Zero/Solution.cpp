class Solution {
public:
    int makeTheIntegerZero(int num1, int num2) {
        for (int k = 0; k <= 60; k++) {
            long long x = 1LL * num1 - 1LL * k * num2;
            if (x >= 0 && countBits(x) <= k && k <= x) return k;
        }
        return -1;
    }
    int countBits(long long x) {
        int count = 0;
        while (x > 0) {
            if ((x & 1) == 1) count++;
            x >>= 1;
        }
        return count;
    }
};
