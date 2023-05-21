class Solution {
public:
    int minLength(string s) {
        stack<char> stack;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s[i] == 'B') {
                if (!stack.empty() && stack.top() == 'A') {
                    stack.pop();
                } else {
                    stack.push(s[i]);
                }
            } else if (s[i] == 'D') {
                if (!stack.empty() && stack.top() == 'C') {
                    stack.pop();
                } else {
                    stack.push(s[i]);
                }
            } else {
                stack.push(s[i]);
            }
        }
        return stack.size();
    }
};
