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
    int rs;
    int distributeCoins(TreeNode* root) {
        rs=0;
        dfs(root);
        return rs;
    }
    int dfs(TreeNode* curr){
        if(curr==nullptr)return 0;
        int l=dfs(curr->left),r=dfs(curr->right);
        rs+=abs(l)+abs(r);
        return curr->val-1+r+l;
    }
};
