class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        backtrack(0, graph, new ArrayList<>());
        return res;
    }
    public void backtrack(int curr, int[][] graph, List<Integer> currPath) {
        if (currPath.contains(curr)) return;
        currPath.add(curr);
        if (curr == graph.length - 1) {
            res.add(new ArrayList<>(currPath));
        } else {
            for (int neighbour : graph[curr]) {
                backtrack(neighbour, graph, currPath);
            }
        }
        currPath.remove(currPath.size() - 1);
    }
}
