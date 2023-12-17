class Solution {
public:
    bool check(int n) {
        vector<int> d;
        while (n > 0) {
            d.push_back(n % 10);
            n /= 10;
        }
        if (d.size() % 2 == 0) {
            for (int i = d.size() / 2 - 1; i >= 0; i--) {
                if (d[i] != d[d.size() - i - 1]) return false;
            }
            return true;
        } else {
            for (int i = (d.size() - 1) / 2 - 1; i >= 0; i--) {
                if (d[i] != d[d.size() - i - 1]) return false;
            }
            return true;
        }
    }
    long long minimumCost(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int median = (n % 2 == 0) ? (nums[n / 2 - 1] + nums[n / 2]) / 2 : nums[n / 2];
        if (check(median)) {
            long long r = 0;
            for (int x : nums) {
                r += abs(x - median);
            }
            return r;
        } else {
            int l = median - 1, h = median + 1;
            while (!check(l)) l--;
            while (!check(h)) h++;
            long long a = 0, b = 0;
            for (int x : nums) {
                a += abs(x - l);
                b += abs(x - h);
            }
            return min(a, b);
        }
    }
};
