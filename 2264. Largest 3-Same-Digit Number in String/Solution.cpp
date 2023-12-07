class Solution {
public:
    string largestGoodInteger(string num) {
        int l = num.length();
        char high = '\0';
        for (int i = 0; i <= l - 3; i++) {
          if (num[i] == num[i + 1] && num[i] == num[i + 2]) {
            if (high == '\0' || high < num[i]) high = num[i];
          }
        }
        return (high == '\0') ? "" : string() + high + high + high;
    }
};
