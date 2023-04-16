class Graph {

    public long[][] d;
    public int n;
    
    public Graph(int n, int[][] edges) {
        d = new long[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], 2000000000);
            d[i][i] = 0;
        }
        for (int[] e : edges) d[e[0]][e[1]] = e[2];
        update();
    }
    
    public void addEdge(int[] edge) {
        d[edge[0]][edge[1]] = edge[2];
        update();
    }
    
    public void update() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return (d[node1][node2] == 2000000000) ? -1 : (int) d[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */