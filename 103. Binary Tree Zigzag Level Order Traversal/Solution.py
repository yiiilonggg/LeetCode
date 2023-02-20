# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res, level = [], []
        if root != None: level.append(root)
        startLeft = True
        while level:
            nodeVals, nextLevel = [], []
            for node in level:
                nodeVals.append(node.val)
                if node.left: nextLevel.append(node.left)
                if node.right: nextLevel.append(node.right)
            if not startLeft: nodeVals = reversed(nodeVals)
            startLeft = not startLeft
            res.append(nodeVals)
            level = nextLevel
        return res