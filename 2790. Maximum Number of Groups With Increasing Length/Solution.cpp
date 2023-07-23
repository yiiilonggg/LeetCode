class Solution {
public:
    int maxIncreasingGroups(vector<int>& usageLimits) {
        sort(begin(usageLimits), end(usageLimits));
        int left = 0, right = usageLimits.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(usageLimits, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (check(usageLimits, left)) ? left : left - 1;
    }

    bool check(vector<int>& u, int x) {
        long long surp = 0;
        int curr, i;
        for (curr = 1, i = 0; curr <= x && i < u.size(); curr++) {
            if (u[i] >= curr) {
                surp += u[i] - curr;
                i++;
            } else {
                if (u[i] + surp >= curr) {
                    surp -= curr - u[i];
                    i++;
                    continue;
                }
                while (i < u.size() && surp < curr) {
                    surp += u[i];
                    i++;
                }
                if (surp >= curr) {
                    surp -= curr;
                } else {
                    return false;
                }
            }
        }
        return curr > x;
    }
};
