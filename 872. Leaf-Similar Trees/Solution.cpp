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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int>l,r;
        bt(l,root1);
        bt(r,root2);
        return l==r;
    }
    void bt(vector<int>&r,TreeNode*curr){
        if(curr==nullptr)return;
        if(curr->left==nullptr&&curr->right==nullptr){
            r.push_back(curr->val);
            return;
        }
        if(curr->left!=nullptr)bt(r,curr->left);
        if(curr->right!=nullptr)bt(r,curr->right);
    }
};
