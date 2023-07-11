# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        self.res = []
        self.dfs(root, target, k)
        return self.res

    def dfs(self, curr, target, k):
        if curr == None: return -1
        if curr.val == target.val:
            self.dfs2(curr, 0, k)
            return 1
        else:
            a, b = self.dfs(curr.left, target, k), self.dfs(curr.right, target, k)
            if a >= 0:
                if a == k: self.res.append(curr.val)
                self.dfs2(curr.right, a + 1, k)
                return a + 1
            if b >= 0:
                if b == k: self.res.append(curr.val)
                self.dfs2(curr.left, b + 1, k)
                return b + 1
            return -1

    def dfs2(self, curr, depth, k):
        if curr == None: return
        if depth > k: return
        if depth == k:
            self.res.append(curr.val)
            return
        self.dfs2(curr.left, depth + 1, k)
        self.dfs2(curr.right, depth + 1, k)
