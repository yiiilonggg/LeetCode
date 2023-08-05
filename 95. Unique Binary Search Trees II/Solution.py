# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        self.memo = dict()
        return self.r(1, n)
    def r(self, left, right):
        if left > right: return [None]
        if left == right: return [TreeNode(left)]
        if (left, right) in self.memo: return self.memo[(left, right)]
        res = [TreeNode(i, l, r) for i in range(left, right + 1) for l in self.r(left, i - 1) for r in self.r(i + 1, right)]
        self.memo[(left, right)] = res
        return res
