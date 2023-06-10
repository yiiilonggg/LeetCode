class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (s(index, mid, n) <= 1L * maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    long long s(int idx, int mid, int n) {
        long long res = 0;
        if (mid > idx) {
            res += 1LL * (mid + mid - idx) * (idx + 1) / 2;
        } else {
            res += 1LL * (mid + 1) * mid / 2 + idx - mid + 1;
        }
        if (mid >= n - idx) {
            res += 1LL * (mid + mid - n + 1 + idx) * (n - idx) / 2;
        } else {
            res += 1LL * (mid + 1) * mid / 2 + n - idx - mid;
        }
        return res - mid;
    }
};
