class Solution {
public:
    int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int res = 0;
        for (int i = 0; i < 7; i++) {
          res += (i < days) ? ((weeks + 1) * (weeks + 2)) / 2 : (weeks * (weeks + 1)) / 2;
          res += (i < days) ? i * (weeks + 1) : i * weeks;
        }
        return res;
    }
};
