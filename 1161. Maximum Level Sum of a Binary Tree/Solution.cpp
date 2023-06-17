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
    int maxLevelSum(TreeNode* root) {
        int high = root->val, level = 1, currLevel = 1;
        deque<TreeNode*> q = { root };
        while (!q.empty()) {
            int l = q.size(), curr = 0;
            for (int i = 0; i < l; i++) {
                TreeNode* node = q.front();
                q.pop_front();
                curr += node->val;
                if (node->left != nullptr) q.push_back(node->left);
                if (node->right != nullptr) q.push_back(node->right);
            }
            if (curr > high) {
                high = curr;
                level = currLevel;
            }
            currLevel++;
        }
        return level;
    }
};
