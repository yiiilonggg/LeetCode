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
    int amountOfTime(TreeNode* root, int start) {
        unordered_map<int,vector<int>>g;
        dfs(root,g);
        deque<int>q;
        unordered_set<int>s;
        int t=0;
        q.push_back(start);
        s.insert(start);
        while(!q.empty()){
            int l=q.size();
            for(int i=0;i<l;i++){
                int c=q.front();
                q.pop_front();
                for(int n:g[c]){
                    if(s.find(n)!=s.end())continue;
                    s.insert(n);
                    q.push_back(n);
                }
            }
            t++;
        }
        return t-1;
    }
    void dfs(TreeNode*curr,unordered_map<int,vector<int>>&g){
        if(curr==nullptr)return;
        if(curr->left!=nullptr){
            g[curr->val].push_back(curr->left->val);
            g[curr->left->val].push_back(curr->val);
            dfs(curr->left,g);
        }
        if(curr->right!=nullptr){
            g[curr->val].push_back(curr->right->val);
            g[curr->right->val].push_back(curr->val);
            dfs(curr->right,g);
        }
    }
};
