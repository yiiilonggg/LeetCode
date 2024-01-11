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
    int maxAncestorDiff(TreeNode* root) {
        return bt(root)[0];
    }
    vector<int> bt(TreeNode*curr){
        if(curr==nullptr)return{0,0,0};
        int s=0,l=curr->val,r=curr->val;
        if(curr->left!=nullptr){
            auto t=bt(curr->left);
            s=max(s,max(t[0],max(abs(t[1]-curr->val),abs(t[2]-curr->val))));
            l=min(l,t[1]);
            r=max(r,t[2]);
        }
        if(curr->right!=nullptr){
            auto t=bt(curr->right);
            s=max(s,max(t[0],max(abs(t[1]-curr->val),abs(t[2]-curr->val))));
            l=min(l,t[1]);
            r=max(r,t[2]);
        }
        return {s,l,r};
    }
};
