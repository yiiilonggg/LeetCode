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
    unordered_map<int, unordered_map<int, vector<TreeNode*>>> memo;
    vector<TreeNode*> generateTrees(int n) {
        return r(1, n);
    }
    vector<TreeNode*> r(int left, int right) {
        vector<TreeNode*> res;
        if (left > right) {
            res.push_back(nullptr);
            return res;
        }
        if (left == right) {
            TreeNode* n = new TreeNode(left);
            res.push_back(n);
            return res;
        }
        if (memo.find(left) != memo.end() && memo[left].find(right) != memo[left].end()) return memo[left][right];
        for (int i = left; i < right + 1; i++) {
            for (TreeNode* l : r(left, i - 1)) {
                for (TreeNode* r : r(i + 1, right)) {
                    TreeNode* n = new TreeNode(i, l, r);
                    res.push_back(n);
                }
            }
        }
        if (memo.find(left) == memo.end()) {
            unordered_map<int, vector<TreeNode*>> m;
            memo[left] = m;
        }
        memo[left][right] = res;
        return res;
    }
};
