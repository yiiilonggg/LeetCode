/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Integer, Node> seen;
    public Node cloneGraph(Node node) {
        seen = new HashMap<>();
        return clone(node);
    }
    public Node clone(Node curr) {
        if (curr == null) return null;
        if (seen.containsKey(curr.val)) return seen.get(curr.val);
        Node c = new Node(curr.val);
        seen.put(curr.val, c);
        for (Node neighbor : curr.neighbors) {
            c.neighbors.add(clone(neighbor));
        }
        return c;
    }
}