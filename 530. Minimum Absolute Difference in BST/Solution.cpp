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
    int res = 100001, prev = -1;
    int getMinimumDifference(TreeNode* root) {
        dfs(root);
        return res;
    }
    void dfs(TreeNode* node) {
        if (node->left != nullptr) dfs(node->left);
        if (prev > -1) res = min(res, node->val - prev);
        prev = node->val;
        if (node->right != nullptr) dfs(node->right);
    }
};
