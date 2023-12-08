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
    string tree2str(TreeNode* root) {
      if (root == nullptr) return "";
      string left = tree2str(root -> left), right = tree2str(root -> right);
      if (right != "") {
        left = "(" + left + ")";
        right = "(" + right + ")";
      } else if (left != "") {
        left = "(" + left + ")";
      }
      return to_string(root -> val) + left + right;
    }
};
