/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<TreeNode*> allPossibleFBT(int n) {
        vector<vector<TreeNode*>> dp(n + 1, vector<TreeNode*>(0, nullptr));
        if (n % 2 == 0) return dp[n];
        TreeNode* root = new TreeNode(0);
        dp[1].push_back(root);
        for (int i = 3; i <= n; i += 2) {
            for (int j = 1; j < i; j += 2) {
                int k = i - j - 1;
                for (const auto& left : dp[j]) {
                    for (const auto& right : dp[k]) {
                        TreeNode* foll = new TreeNode(0, left, right);
                        dp[i].push_back(foll);
                    }
                }
            }
        }
        return dp[n];
    }
};
