class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isalnum(s[left])) left++;
            while (left < right && !isalnum(s[right])) right--;
            if (isupper(s[left])) {
                s[left] = (char) (s[left] + 32);
            } else if (isupper(s[right])) {
                s[right] = (char) (s[right] + 32);
            } else if (s[left] == s[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
};
