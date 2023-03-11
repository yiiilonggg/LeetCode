# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        self.root = head
        n = 0
        while head != None:
            head = head.next
            n += 1
        return self.build(0, n - 1)
    def build(self, left, right):
        if left > right: return None
        mid = (left + right) // 2
        leftTree = self.build(left, mid - 1)
        root = TreeNode(self.root.val)
        self.root = self.root.next
        root.left = leftTree
        root.right = self.build(mid + 1, right)
        return root