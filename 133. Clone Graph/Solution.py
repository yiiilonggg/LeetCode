"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        self.seen = dict()
        return self.clone(node)
    
    def clone(self, node):
        if not node: return None
        if node.val in self.seen: return self.seen[node.val]
        curr = Node(node.val)
        self.seen[node.val] = curr
        for neighbor in node.neighbors:
            curr.neighbors.append(self.clone(neighbor))
        return curr