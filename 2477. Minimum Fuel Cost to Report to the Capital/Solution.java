class Solution {
    int n;
    long res;
    List<Integer>[] graph;
    public long minimumFuelCost(int[][] roads, int seats) {
        n = roads.length + 1;
        res = 0;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        dfs(0, -1, seats, 0);
        return res;
    }
    public int dfs(int curr, int parent, int seats, int depth) {
        List<Integer> neighbours = graph[curr];
        int passengers = 1, count = (curr == 0) ? neighbours.size() : neighbours.size() - 1;
        for (int neighbour : neighbours) {
            if (neighbour == parent) continue;
            int incoming = dfs(neighbour, curr, seats, depth + 1);
            if (incoming > 0) {
                passengers += incoming;
            } else {
                count--;
            }
        }
        res += count + (passengers / seats) * depth;
        return passengers % seats;
    }
}