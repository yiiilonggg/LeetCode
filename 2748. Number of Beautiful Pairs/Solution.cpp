class Solution {
public:
    int countBeautifulPairs(vector<int>& nums) {
        int n = nums.size(), count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int first = nums[i], second = nums[j] % 10;
                while (first / 10 > 0) first /= 10;
                if (gcd(first, second) == 1) count++;
            }
        }
        return count;
    }

    int gcd(int x, int y) {
        if (y > x) return gcd(y, x);
        if (y == 0) return x;
        return gcd(y, x % y);
    }
};
