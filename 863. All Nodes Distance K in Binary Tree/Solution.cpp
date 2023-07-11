/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> res;
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        dfs(root, target, k);
        return res;
    }

    int dfs(TreeNode* curr, TreeNode* target, int k) {
        if (curr == nullptr) return -1;
        if (curr -> val == target -> val) {
            dfs2(curr, 0, k);
            return 1;
        } else {
            int a = dfs(curr -> left, target, k), b = dfs(curr -> right, target, k);
            if (a >= 0) {
                if (a == k) res.push_back(curr -> val);
                dfs2(curr -> right, a + 1, k);
                return a + 1;
            }
            if (b >= 0) {
                if (b == k) res.push_back(curr -> val);
                dfs2(curr -> left, b + 1, k);
                return b + 1;
            }
            return -1;
        }
    }

    void dfs2(TreeNode* curr, int depth, int k) {
        if (curr == nullptr) return;
        if (depth > k) return;
        if (depth == k) {
            res.push_back(curr -> val);
            return;
        }
        dfs2(curr -> left, depth + 1, k);
        dfs2(curr -> right, depth + 1, k);
    }
};
