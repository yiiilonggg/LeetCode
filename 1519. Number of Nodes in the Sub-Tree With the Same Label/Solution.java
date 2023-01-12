class Solution {
    List<Integer>[] graph;
    char[] labelArray;
    int[] res;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new List[n];
        labelArray = labels.toCharArray();
        res = new int[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0, -1, new int[26]);
        return res;
    }
    public void dfs(int curr, int parent, int[] letters) {
        List<Integer> neighbours = graph[curr];
        int prev = letters[labelArray[curr] - 'a'];
        letters[labelArray[curr] - 'a']++;
        for (int neighbour : neighbours) {
            if (neighbour == parent) continue;
            dfs(neighbour, curr, letters);
        }
        res[curr] = letters[labelArray[curr] - 'a'] - prev;
    }
}