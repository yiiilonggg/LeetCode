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
    int minDepth(TreeNode* root) {
        int depth = 0;
        queue<TreeNode*> q;
        if (root != nullptr) q.push(root);
        while (!q.empty()) {
            int l = q.size();
            depth++;
            for (int i = 0; i < l; i++) {
                TreeNode* curr = q.front();
                q.pop();
                if (curr -> left == nullptr && curr -> right == nullptr) return depth;
                if (curr -> left != nullptr) q.push(curr -> left);
                if (curr -> right != nullptr) q.push(curr -> right);
            }
        }
        return depth;
    }
};
