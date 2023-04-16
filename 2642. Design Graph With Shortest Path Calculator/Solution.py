class Graph:

    def __init__(self, n: int, edges: List[List[int]]):
        self.d = [[2000000000 for i in range(n)] for j in range(n)]
        self.n = n
        for i in range(n): self.d[i][i] = 0
        for x, y, z in edges: self.d[x][y] = z
        self.update()
    
    def update(self):
        for k in range(self.n):
            for i in range(self.n):
                for j in range(self.n):
                    self.d[i][j] = min(self.d[i][j], self.d[i][k] + self.d[k][j])

    def addEdge(self, edge: List[int]) -> None:
        self.d[edge[0]][edge[1]] = edge[2]

    def shortestPath(self, node1: int, node2: int) -> int:
        return self.d[node1][node2] if self.d[node1][node2] != 2000000000 else -1


# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)