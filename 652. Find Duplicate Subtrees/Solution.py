# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        self.hash, self.seen, self.res = dict(), dict(), []
        self.hashing(root)
        return self.res
    def hashing(self, curr):
        s = ["*C", str(curr.val)]
        if curr.left or curr.right:
            if curr.left and curr.left not in self.hash: self.hashing(curr.left)
            if curr.right and curr.right not in self.hash: self.hashing(curr.right)
            s.append(self.hash[curr.left] if curr.left else "*L")
            s.append(self.hash[curr.right] if curr.right else "*L")
        p = "".join(s)
        if p in self.seen and self.seen[p] == 1: self.res.append(curr)
        self.seen[p] = 1 if p not in self.seen else self.seen[p] + 1
        self.hash[curr] = p