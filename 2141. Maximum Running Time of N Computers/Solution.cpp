class Solution {
public:
    long long maxRunTime(int n, vector<int>& batteries) {
        long long left = 0, right = accumulate(begin(batteries), end(batteries), 0LL) / n;
        sort(begin(batteries), end(batteries), [](const auto& a, const auto& b) { return b < a; });
        while (left < right) {
            long long mid = (left + right) / 2;
            if (check(n, batteries, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (check(n, batteries, left)) ? left : left - 1;
    }

    bool check(int n, vector<int>& arr, long long x) {
        long long rem = 0;
        for (int i = 0; i < n; i++) rem += max(x - 1LL * arr[i], 0LL);
        for (int i = n; i < arr.size(); i++) rem -= 1LL * arr[i];
        return rem <= 0;
    }
};
