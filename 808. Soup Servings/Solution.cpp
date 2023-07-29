class Solution {
public:
    unordered_map<int, unordered_map<int, double>> memo;
    double soupServings(int n) {
        int m = ceil(1.0 * n / 25);
        for (int i = 0; i < m + 1; i++) {
            if (r(i, i) > 1 - 0.00001) return 1;
        }
        return r(m, m);
    }

    double r(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (memo.find(a) != memo.end() && memo[a].find(b) != memo[a].end()) return memo[a][b];
        double w = r(a - 4, b), x = r(a - 3, b - 1), y = r(a - 2, b - 2), z = r(a - 1, b - 3);
        if (memo.find(a) == memo.end()) {
            unordered_map<int, double> c;
            memo[a] = c;
        }
        memo[a][b] = 0.25 * (w + x + y + z);
        return memo[a][b];
    }
};
