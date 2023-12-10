class Solution {
public:
    int countTestedDevices(vector<int>& batteryPercentages) {
        int test = 0, l = batteryPercentages.size();
        for (int i = 0; i < l; i++) {
            if (batteryPercentages[i] > test) test++;
        }
        return test;
    }
};
