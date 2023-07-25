class Solution {
public:
    double myPow(double x, int n) {
        return (n >= 0) ? r(x, n) : 1 / r(x, -1LL * n);
    }

    double r(double x, long long p) {
        if (p == 0) return 1;
        if (p % 2 == 0) return r(x * x, p / 2);
        return x * r(x * x, (p - 1) / 2);
    }
};
