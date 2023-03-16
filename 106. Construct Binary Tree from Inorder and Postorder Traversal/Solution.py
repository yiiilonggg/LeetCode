# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n = len(inorder)
        self.curr = n - 1
        self.seen = dict([[inorder[i], i] for i in range(n)])
        return self.dfs(0, n - 1, postorder)
    def dfs(self, left, right, postorder):
        if left > right: return None
        node = TreeNode(postorder[self.curr])
        self.curr -= 1
        node.right = self.dfs(self.seen[node.val] + 1, right, postorder)
        node.left = self.dfs(left, self.seen[node.val] - 1, postorder)
        return node