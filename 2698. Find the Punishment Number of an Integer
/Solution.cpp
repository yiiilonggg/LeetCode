class Solution {
public:
    int punishmentNumber(int n) {
        vector<int> p = {1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000};
        int res = 0;
        for (int i : p) {
            if (i <= n) res += i * i;
        }
        return res;
    }

    bool find(string x, int target, int curr) {
        if (curr > target) return false;
        if (curr == target && x.length() == 0) return true;
        int n = x.length();
        for (int i = 1; i <= n; i++) {
            int y = stoi(x.substr(0, i));
            if (curr + y > target) return false;
            if (find(x.substr(i), target, curr + y)) return true;
        }
        return false;
    }
};
