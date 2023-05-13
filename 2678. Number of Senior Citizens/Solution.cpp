class Solution {
public:
    int countSeniors(vector<string>& details) {
        int c = 0;
        for (string d : details) {
            int a = stoi(d.substr(11, 2));
            if (a > 60) c++;
        }
        return c;
    }
};