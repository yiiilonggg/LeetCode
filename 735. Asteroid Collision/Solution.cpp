class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> stack, res;
        for (const auto& a : asteroids) {
            if (a < 0) {
                while (!stack.empty() && stack.back() < -a) {
                    stack.pop_back();
                } 
                if (!stack.empty() && stack.back() == -a) {
                    stack.pop_back();
                } else if (stack.empty()) {
                    res.push_back(a);
                }
            } else {
                stack.push_back(a);
            }
        }
        for (int i = 0; i < stack.size(); i++) res.push_back(stack[i]);
        return res;
    }
};
