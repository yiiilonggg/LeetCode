class Solution {
public:
    int numberOfEmployeesWhoMetTarget(vector<int>& hours, int target) {
        int res = 0;
        for (int h : hours) {
            if (h >= target) res++;
        }
        return res;
    }
};
