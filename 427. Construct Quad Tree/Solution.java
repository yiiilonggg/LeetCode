/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return recurse(grid, 0, 0, grid.length);
    }
    public Node recurse(int[][] grid, int x, int y, int n) {
        if (n == 1) return new Node(grid[x][y] == 1, true);
        Node topleft = recurse(grid, x, y, n / 2);
        Node topright = recurse(grid, x, y + n / 2, n / 2);
        Node bottomleft = recurse(grid, x + n / 2, y, n / 2);
        Node bottomright = recurse(grid, x + n / 2, y + n / 2, n / 2);
        if (topleft.isLeaf && topright.isLeaf && bottomleft.isLeaf && bottomright.isLeaf &&
            topleft.val == topright.val && topright.val == bottomleft.val && bottomleft.val == bottomright.val && bottomright.val == topleft.val) return new Node(topleft.val, true);
        return new Node(false, false, topleft, topright, bottomleft, bottomright);
    }
}