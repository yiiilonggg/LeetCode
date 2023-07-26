class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        int left = 1, right = 10000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (check(dist, hour, left)) ? left : -1;
    }
    bool check(vector<int>& arr, double hour, int x) {
        double curr = 0;
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) curr += ceil((double) arr[i] / x);
        curr += (double) arr[n - 1] / x;
        return curr <= hour;
    }
};
